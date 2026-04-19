package com.sohlman.liferay.bfdms.store;

import java.io.IOException;
import java.io.InputStream;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface BinaryStore {

	void store(long companyId, String path, InputStream inputStream)
		throws IOException;

	InputStream retrieve(long companyId, String path) throws IOException;

	void delete(long companyId, String path) throws IOException;

	boolean exists(long companyId, String path) throws IOException;

	/**
	 * Iterates all stored paths for a company scope.
	 * path in store but not in DB → orphaned binary.
	 * FileData in DB but path missing → data loss.
	 */
	void forEach(long companyId, PathConsumer consumer) throws IOException;

	@FunctionalInterface
	interface PathConsumer {

		void accept(String path) throws IOException;

	}

	String getType();

}