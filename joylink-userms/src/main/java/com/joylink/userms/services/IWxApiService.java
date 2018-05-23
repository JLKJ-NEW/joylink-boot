package com.joylink.userms.services;

import com.joylink.userms.vo.wx.WxPageAccessToken;

public interface IWxApiService {
	
	/**
	 * 获取页面授权access token
	 * @param code
	 * @return
	 */
	WxPageAccessToken getPageAccessToken(String code);

}
