package com.joylink.userms.services;

import com.joylink.userms.vo.UserInfo;
import com.joylink.userms.vo.client.LoginVO;

public interface IAuthenticateService {
	
	/**
	 * 获取微信扫码登陆url
	 * @param sessionId
	 * @return
	 */
	LoginVO getLoginUrl(String sessionId);
	
	/**
	 * 获取登陆状态/token
	 * @param sessionId
	 * @return
	 */
	LoginVO getToken(String sessionId);
	
	/**
	 * 登陆
	 * @param wxId
	 * @param sessionId 
	 */
	void login(String wxId, String sessionId);
	
	/**
	 * 根据token获取用户信息
	 * @param token
	 * @return
	 */
	UserInfo getUserInfo(String token);

}
