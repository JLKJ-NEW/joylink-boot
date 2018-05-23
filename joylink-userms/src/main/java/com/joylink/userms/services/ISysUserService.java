package com.joylink.userms.services;

import com.joylink.userms.vo.UserInfo;

public interface ISysUserService {

	void createUser(UserInfo userInfo, String vdcode);
	
	/**
	 * 根据openId查询用户
	 * @param openid
	 */
	UserInfo findUser(String openid);

}
