package com.sohlman.liferay.bfdms.store.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.sohlman.liferay.bfdms.configuration.FingerPrintNamingStrategyConfiguration;
import com.sohlman.liferay.bfdms.model.FileInfo;
import com.sohlman.liferay.bfdms.store.FolderFile;
import com.sohlman.liferay.bfdms.store.StorageNamingStrategy;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
    configurationPid = "com.sohlman.liferay.bfdms.configuration.FingerPrintNamingStrategyConfiguration",
    property = "naming.strategy.type=fingerprint",
    service = StorageNamingStrategy.class
)
public class FingerPrintNamingStrategy implements StorageNamingStrategy {

    @Override
    public FolderFile generate(FileInfo fileInfo, String fingerPrint) {
        String[] parts = fingerPrint.split("\\.");

        // fingerPrint format: "BLAKE3.<64-hex>.<size>"
        String hash = parts[1];
        String size = parts[2];

        StringBundler randomBundler = new StringBundler(5);
        for (int i = 0; i < 5; i++) {
            randomBundler.append(
                _RANDOM_CHARS.charAt(
                    ThreadLocalRandom.current().nextInt(_RANDOM_CHARS.length())));
        }
        String randomString = randomBundler.toString();

        String name = StringBundler.concat(hash,"-", size, "-", randomString);

        int prefixLength = _folderCharsPerLevel * _folderDepth;

        String storedName = _stripFolderPrefixFromName
            ? name.substring(prefixLength)
            : name;

        return new FolderFile(_buildFolder(name), storedName);
    }

    @Override
    public String resolvePath(String storedName, String fingerPrint) {
        String folderSource = _stripFolderPrefixFromName
            ? fingerPrint.split("\\.")[1]  // reconstruct folder from hash in fingerprint
            : storedName;                  // folder chars are still at the start of storedName

        return _buildFolder(folderSource) + "/" + storedName;
    }

    @Override
    public String getType() {
        return "fingerprint";
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> props) {
        FingerPrintNamingStrategyConfiguration config =
            ConfigurableUtil.createConfigurable(
                FingerPrintNamingStrategyConfiguration.class, props);

        _folderCharsPerLevel       = Math.max(1, config.folderCharsPerLevel());
        _folderDepth               = Math.min(9, Math.max(1, config.folderDepth()));
        _stripFolderPrefixFromName = config.stripFolderPrefixFromName();
    }

    private String _buildFolder(String source) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _folderDepth; i++) {
            if (i > 0) sb.append("/");
            sb.append(source, i * _folderCharsPerLevel, (i + 1) * _folderCharsPerLevel);
        }
        return sb.toString();
    }

    private static final String _RANDOM_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";

    private volatile int _folderCharsPerLevel = 2;
    private volatile int _folderDepth         = 2;
    private volatile boolean _stripFolderPrefixFromName = false;

}
