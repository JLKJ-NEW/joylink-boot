package com.joylink.userms.cache;

import java.util.HashMap;
import java.util.Map;

import com.joylink.userms.constants.WxConstants;
import com.joylink.userms.vo.wx.WxAccessToken;

public class WxAccessTokenCache {
	
	public static final Map<String, Object> LocalCache = new HashMap<>();
	
	private WxAccessTokenCache() {}
	
	public synchronized static void put(String key, Object val) {
		LocalCache.put(key, val);
	}
	
	public synchronized static Object get(String key) {
		return LocalCache.get(key);
	}
	
	public synchronized static WxAccessToken getWxAccessToken() {
		return (WxAccessToken) LocalCache.get(WxConstants.ACCESS_TOKEN);
	}
	
}
