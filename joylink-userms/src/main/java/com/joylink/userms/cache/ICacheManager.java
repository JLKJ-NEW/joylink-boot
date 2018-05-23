package com.joylink.userms.cache;

public interface ICacheManager {
	
	public void put(String key, Object entity);
	
	public Object get(String key);
	
	public void remove(String key);
	
}
