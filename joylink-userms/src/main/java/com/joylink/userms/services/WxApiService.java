package com.joylink.userms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.joylink.userms.cache.ICacheManager;
import com.joylink.userms.configuration.configProp.WeChatConfig;
import com.joylink.userms.vo.wx.WxPageAccessToken;

@Service
public class WxApiService implements IWxApiService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WeChatConfig weChatConfig;
	
	@Autowired
	private ICacheManager iCacheManager;
	
	@Override
	public WxPageAccessToken getPageAccessToken(String code) {
		WxPageAccessToken pat = (WxPageAccessToken) iCacheManager.get(code);
		if(null == pat) {
			pat = restTemplate.getForObject(weChatConfig.getPageAccessTokenUrl(code), WxPageAccessToken.class);
			iCacheManager.put(code, pat);
		}
		return pat;
	}

}
