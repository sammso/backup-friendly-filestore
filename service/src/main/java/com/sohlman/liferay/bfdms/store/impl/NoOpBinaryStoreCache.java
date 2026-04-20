package com.sohlman.liferay.bfdms.store.impl;

import com.sohlman.liferay.bfdms.store.BinaryStoreCache;

import java.io.InputStream;

import org.osgi.service.component.annotations.Component;

@Component(
	property = "cache.type=noop",
	service = BinaryStoreCache.class
)
public class NoOpBinaryStoreCache implements BinaryStoreCache {

	@Override
	public InputStream get(long companyId, String path) {
		return null;
	}

	@Override
	public InputStream wrap(long companyId, String path, InputStream source) {
		return source;
	}

	@Override
	public void invalidate(long companyId, String path) {
	}

	@Override
	public void invalidateAll(long companyId) {
	}

	@Override
	public String getType() {
		return "noop";
	}

}
