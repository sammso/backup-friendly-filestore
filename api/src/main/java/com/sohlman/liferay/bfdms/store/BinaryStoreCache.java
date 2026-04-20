package com.sohlman.liferay.bfdms.store;

import java.io.IOException;
import java.io.InputStream;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface BinaryStoreCache {

	InputStream get(long companyId, String path) throws IOException;

	/**
	 * Wraps source in a tee stream that populates the cache on first read.
	 * Concurrent calls for the same path: first caller caches, others pass through.
	 * No-op implementation returns source unchanged.
	 */
	InputStream wrap(long companyId, String path, InputStream source)
		throws IOException;

	void invalidate(long companyId, String path) throws IOException;

	void invalidateAll(long companyId) throws IOException;

	String getType();

}
