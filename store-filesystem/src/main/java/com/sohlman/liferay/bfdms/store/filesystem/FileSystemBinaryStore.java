package com.sohlman.liferay.bfdms.store.filesystem;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.sohlman.liferay.bfdms.store.BinaryStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
	configurationPid = "com.sohlman.liferay.bfdms.store.filesystem.FileSystemBinaryStoreConfiguration",
	immediate = true,
	property = "binary.store.type=filesystem",
	service = BinaryStore.class
)
public class FileSystemBinaryStore implements BinaryStore {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		FileSystemBinaryStoreConfiguration fileSystemBinaryStoreConfiguration =
			ConfigurableUtil.createConfigurable(
				FileSystemBinaryStoreConfiguration.class, properties);


		String rootDirPath = fileSystemBinaryStoreConfiguration.rootDir();

		if (rootDirPath == null || rootDirPath.isEmpty()) {
			rootDirPath = "data/document_library";
		}

		File rootDir = new File(rootDirPath);

		if (!rootDir.isAbsolute()) {
			rootDir = new File(PropsUtil.get(PropsKeys.LIFERAY_HOME), rootDirPath);
		}

		FileUtil.mkdirs(rootDir);

		_rootDir = rootDir;
		_log.info(String.format("FileSystemBinaryStore  FileSystemBinaryStoreConfiguration: %s, rootDirectory: %s", (fileSystemBinaryStoreConfiguration==null?"'Not found'" : fileSystemBinaryStoreConfiguration.toString()), rootDirPath));
	}

	@Override
	public void store(long companyId, String path, InputStream inputStream)
		throws IOException {

		File file = _getFile(path);

		file.getParentFile().mkdirs();

		try (FileOutputStream out = new FileOutputStream(file)) {
			inputStream.transferTo(out);
		}
	}

	@Override
	public InputStream retrieve(long companyId, String path) throws IOException {
		return new FileInputStream(_getFile(path));
	}

	@Override
	public void delete(long companyId, String path) throws IOException {
		_deleteRecursive(_getFile(path));
	}

	@Override
	public boolean exists(long companyId, String path) throws IOException {
		return _getFile(path).exists();
	}

	@Override
	public void forEach(long companyId, PathConsumer consumer) throws IOException {
		File root = _rootDir;

		if (root == null || !root.exists()) {
			return;
		}

		File[] level1 = root.listFiles();

		if (level1 == null) {
			return;
		}

		for (File dir1 : level1) {
			if (!dir1.isDirectory()) {
				continue;
			}

			File[] level2 = dir1.listFiles();

			if (level2 == null) {
				continue;
			}

			for (File dir2 : level2) {
				if (!dir2.isDirectory()) {
					continue;
				}

				File[] files = dir2.listFiles();

				if (files == null) {
					continue;
				}

				for (File file : files) {
					if (file.isFile()) {
						consumer.accept(
							dir1.getName() + "/" + dir2.getName() + "/" +
								file.getName());
					}
				}
			}
		}
	}

	@Override
	public String getType() {
		return "filesystem";
	}

	private File _getFile(String path) {
		return new File(_rootDir, path);
	}

	private void _deleteRecursive(File file) {
		File rootDir = _rootDir;

		if (rootDir == null || file.equals(rootDir) || !file.exists()) {
			return;
		}

		if (file.isDirectory()) {
			String[] children = file.list();

			if (children != null && children.length > 0) {
				return;
			}
		}

		if (!file.delete()) {
			_log.error("Could not delete " + file.getAbsolutePath());

			return;
		}

		_deleteRecursive(file.getParentFile());
	}

	private volatile File _rootDir;

	private static final Log _log = LogFactoryUtil.getLog(
		FileSystemBinaryStore.class);

}
