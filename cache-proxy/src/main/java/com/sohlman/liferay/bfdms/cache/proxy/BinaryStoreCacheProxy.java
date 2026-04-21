package com.sohlman.liferay.bfdms.cache.proxy;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sohlman.liferay.bfdms.store.BinaryStoreCache;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(
    configurationPid = "com.sohlman.liferay.bfdms.cache.proxy.BinaryStoreCacheConfiguration",
    immediate = true,
    property = "service.ranking:Integer=1000",
    service = BinaryStoreCache.class
)
public class BinaryStoreCacheProxy implements BinaryStoreCache {

    @Override
    public InputStream get(long companyId, String path) throws IOException {
        InputStream stream = _getActive().get(companyId, path);
        return (stream != null) ? _timed(path, stream) : null;
    }

    @Override
    public InputStream wrap(long companyId, String path, InputStream source)
        throws IOException {

        return _timed(path, _getActive().wrap(companyId, path, source));
    }

    @Override
    public void invalidate(long companyId, String path) throws IOException {
        _getActive().invalidate(companyId, path);
    }

    @Override
    public void invalidateAll(long companyId) throws IOException {
        _getActive().invalidateAll(companyId);
    }

    @Override
    public String getType() {
        return "proxy";
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> props) {
        BinaryStoreCacheConfiguration config = ConfigurableUtil.createConfigurable(
            BinaryStoreCacheConfiguration.class, props);

        _activeCacheType       = config.cacheType();
        _statsEnabled          = config.statsEnabled();
        _popularFilesMaxCount  = config.popularFilesMaxCount();
        _slowestFilesMaxCount  = config.slowestFilesMaxCount();

        if (_statsEnabled) {
            _reschedule(config.reportIntervalMinutes());
        }
        else {
            _stopScheduler();
            _stats.clear();
        }
    }

    @Deactivate
    protected void deactivate() {
        _stopScheduler();
    }

    @Reference(
        cardinality = ReferenceCardinality.AT_LEAST_ONE,
        policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY,
        target = "(cache.type=*)",
        bind = "_addCache",
        unbind = "_removeCache"
    )
    protected void _addCache(BinaryStoreCache cache, Map<String, Object> props) {
        _caches.put((String) props.get("cache.type"), cache);
    }

    protected void _removeCache(BinaryStoreCache cache, Map<String, Object> props) {
        _caches.remove((String) props.get("cache.type"));
    }

    private BinaryStoreCache _getActive() {
        BinaryStoreCache cache = _caches.get(_activeCacheType);
        return (cache != null) ? cache : _caches.get("noop");
    }

    private InputStream _timed(String path, InputStream in) {
        if (!_statsEnabled) {
            return in;
        }

        return new TimingInputStream(in,
            (durationMs, bytes) ->
                _stats.computeIfAbsent(path, PathStats::new).record(durationMs, bytes));
    }

    private void _reschedule(int intervalMinutes) {
        _stopScheduler();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(
            this::_logReport, intervalMinutes, intervalMinutes, TimeUnit.MINUTES);
        _scheduler = scheduler;
        _reportIntervalMinutes = intervalMinutes;
    }

    private void _stopScheduler() {
        ScheduledExecutorService s = _scheduler;
        if (s != null) {
            s.shutdownNow();
            _scheduler = null;
        }
    }

    private void _logReport() {
        List<PathStats> entries = new ArrayList<>(_stats.values());
        _stats.clear();

        if (entries.isEmpty()) {
            return;
        }

        List<PathStats> popular = entries.stream()
            .sorted(Comparator.comparingLong(PathStats::getHitCount).reversed())
            .limit(_popularFilesMaxCount)
            .collect(Collectors.toList());

        List<PathStats> slowest = entries.stream()
            .sorted(Comparator.comparingLong(PathStats::getAvgTimeMs).reversed())
            .limit(_slowestFilesMaxCount)
            .collect(Collectors.toList());

        StringBundler sb = new StringBundler();
        sb.append(StringPool.OPEN_CURLY_BRACE);
        sb.append(StringPool.QUOTE); sb.append("intervalMinutes"); sb.append(StringPool.QUOTE);
        sb.append(StringPool.COLON); sb.append(_reportIntervalMinutes);
        sb.append(StringPool.COMMA); sb.append(StringPool.QUOTE); sb.append("topByDownloads"); sb.append(StringPool.QUOTE);
        sb.append(StringPool.COLON); sb.append(_toJsonArray(popular));
        sb.append(StringPool.COMMA); sb.append(StringPool.QUOTE); sb.append("topSlowest"); sb.append(StringPool.QUOTE);
        sb.append(StringPool.COLON); sb.append(_toJsonArray(slowest));
        sb.append(StringPool.CLOSE_CURLY_BRACE);

        _statLog.info(sb.toString());
    }

    private static String _toJsonArray(List<PathStats> list) {
        StringBundler sb = new StringBundler();
        sb.append(StringPool.OPEN_BRACKET);
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(StringPool.COMMA);
            sb.append(_toJsonEntry(list.get(i)));
        }
        sb.append(StringPool.CLOSE_BRACKET);
        return sb.toString();
    }

    private static String _toJsonEntry(PathStats s) {
        StringBundler sb = new StringBundler();
        sb.append(StringPool.OPEN_CURLY_BRACE);
        sb.append(StringPool.QUOTE).append("path").append(StringPool.QUOTE);
        sb.append(StringPool.COLON).append(StringPool.QUOTE).append(s.getPath()).append(StringPool.QUOTE);
        sb.append(StringPool.COMMA).append(StringPool.QUOTE).append("hits").append(StringPool.QUOTE);
        sb.append(StringPool.COLON).append(s.getHitCount());
        sb.append(StringPool.COMMA).append(StringPool.QUOTE).append("avgTimeMs").append(StringPool.QUOTE);
        sb.append(StringPool.COLON).append(s.getAvgTimeMs());
        sb.append(StringPool.COMMA).append(StringPool.QUOTE).append("minTimeMs").append(StringPool.QUOTE);
        sb.append(StringPool.COLON).append(s.getMinTimeMs());
        sb.append(StringPool.COMMA).append(StringPool.QUOTE).append("maxTimeMs").append(StringPool.QUOTE);
        sb.append(StringPool.COLON).append(s.getMaxTimeMs());
        sb.append(StringPool.COMMA).append(StringPool.QUOTE).append("totalBytes").append(StringPool.QUOTE);
        sb.append(StringPool.COLON).append(s.getTotalBytes());
        sb.append(StringPool.CLOSE_CURLY_BRACE);
        return sb.toString();
    }

    private static final Log _log = LogFactoryUtil.getLog(BinaryStoreCacheProxy.class);
    private static final Log _statLog = LogFactoryUtil.getLog("BFDMS-Stats");


    private final ConcurrentHashMap<String, BinaryStoreCache> _caches =
        new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, PathStats> _stats =
        new ConcurrentHashMap<>();

    private volatile String _activeCacheType     = "noop";
    private volatile boolean _statsEnabled       = false;
    private volatile int _popularFilesMaxCount   = 10;
    private volatile int _slowestFilesMaxCount    = 10;
    private volatile int _reportIntervalMinutes   = 60;
    private volatile ScheduledExecutorService _scheduler;

}