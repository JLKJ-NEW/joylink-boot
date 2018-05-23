package com.joylink.userms.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

public class GuavaCacheManager implements ICacheManager {
	
	@SuppressWarnings("rawtypes")
	private CacheBuilder cacheBuilder;
	
	private Cache<String, Object> cache;
	
	public GuavaCacheManager() {}
	
	@SuppressWarnings("unchecked")
	public void setCacheBuilder(CacheBuilder<Object, Object> cacheBuilder) {
		this.cacheBuilder = cacheBuilder;
		this.cache = this.cacheBuilder.build(new CacheLoader<String, Object>() {
			@Override
			public Object load(String arg0) throws Exception {
				return null;
			}
		});
	}

	@Override
	public void put(String key, Object entity) {
		cache.put(key, entity);
	}

	@Override
	public Object get(String key) {
		return cache.getIfPresent(key);
	}

	@Override
	public void remove(String key) {
		cache.invalidate(key);
	}

}
