package com.sohlman.liferay.bfdms.cache.proxy;

import java.util.concurrent.atomic.AtomicLong;

class PathStats {

    PathStats(String path) {
        _path = path;
    }

    void record(long durationMs, long bytes) {
        _hitCount.incrementAndGet();
        _totalTimeMs.addAndGet(durationMs);
        _totalBytes.addAndGet(bytes);

        long min = _minTimeMs.get();
        while (durationMs < min && !_minTimeMs.compareAndSet(min, durationMs)) {
            min = _minTimeMs.get();
        }

        long max = _maxTimeMs.get();
        while (durationMs > max && !_maxTimeMs.compareAndSet(max, durationMs)) {
            max = _maxTimeMs.get();
        }
    }

    String getPath() {
        return _path;
    }

    long getHitCount() {
        return _hitCount.get();
    }

    long getAvgTimeMs() {
        long hits = _hitCount.get();
        return (hits == 0) ? 0 : _totalTimeMs.get() / hits;
    }

    long getMinTimeMs() {
        long min = _minTimeMs.get();
        return (min == Long.MAX_VALUE) ? 0 : min;
    }

    long getMaxTimeMs() {
        return _maxTimeMs.get();
    }

    long getTotalBytes() {
        return _totalBytes.get();
    }

    private final String _path;
    private final AtomicLong _hitCount    = new AtomicLong();
    private final AtomicLong _totalTimeMs = new AtomicLong();
    private final AtomicLong _minTimeMs   = new AtomicLong(Long.MAX_VALUE);
    private final AtomicLong _maxTimeMs   = new AtomicLong();
    private final AtomicLong _totalBytes  = new AtomicLong();

}