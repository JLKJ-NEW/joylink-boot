package com.joylink.userms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.joylink.userms.cache.ICacheManager;
import com.joylink.userms.configuration.configProp.WeChatConfig;
import com.joylink.userms.dao.SysUserMapper;
import com.joylink.userms.entity.SysUser;
import com.joylink.userms.entity.SysUserExample;
import com.joylink.userms.exceptions.BusinessException;
import com.joylink.userms.exceptions.DBException;
import com.joylink.userms.exceptions.ExceptionMapping;
import com.joylink.userms.util.EncryptUtil;
import com.joylink.userms.vo.UserInfo;
import com.joylink.userms.vo.client.LoginVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticateService implements IAuthenticateService {
	
	/**
	 * 登陆状态： 0-待登陆
	 */
	private static final String STATUS_WAIT = "0"; 
	
	/**
	 * 登陆状态： 1-登陆中
	 */
	private static final String STATUS_LOADING = "1";
	
	/**
	 * 登陆状态： 2-登陆成功
	 */
	private static final String STATUS_SUCCESS = "2";
	
	@Autowired
	private WeChatConfig weChatConfig;
	
	@Autowired
	private ICacheManager iCacheManager;
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public void login(String wxId, String sessionId) {
		if(StringUtils.isEmpty(sessionId)) throw new BusinessException(ExceptionMapping.ARGUMENT_ILLEGAL);
		LoginVO loginVo = (LoginVO) iCacheManager.get(sessionId);
		if(ObjectUtils.isEmpty(loginVo)) {
			throw new BusinessException(ExceptionMapping.CLIENT_LOGIN_INVALID);
		}
		SysUserExample example = new SysUserExample();
		example.createCriteria().andWxIdEqualTo(wxId);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)) {
			throw new DBException(ExceptionMapping.DATA_NOT_EXIST);
		}
		SysUser sysUser = list.get(0);
		String encodeStr = wxId + System.currentTimeMillis();
		String token = EncryptUtil.md5(encodeStr);
		loginVo.setToken(token);
		loginVo.setStatus(STATUS_SUCCESS);
		// 更新缓存
		iCacheManager.put(sessionId, loginVo);
		iCacheManager.put(token, sysUser);
	}

	@Override
	public LoginVO getLoginUrl(String sessionId) {
		log.info("会话ID: "+sessionId);
		LoginVO loginVo = new LoginVO();
		loginVo.setStatus(STATUS_WAIT);
		iCacheManager.put(sessionId, loginVo);
		String url = String.format(weChatConfig.getClientLoginUrl(), sessionId);
		LoginVO loginUrl = new LoginVO();
		loginUrl.setUrl(url);
		loginUrl.setSessionId(sessionId);
		return loginUrl;
	}

	@Override
	public LoginVO getToken(String sessionId) {
		LoginVO loginVo = (LoginVO) iCacheManager.get(sessionId);
		return loginVo;
	}

	@Override
	public UserInfo getUserInfo(String token) {
		SysUser sysUser = (SysUser) iCacheManager.get(token);
		if(ObjectUtils.isEmpty(sysUser)) {
			throw new BusinessException(ExceptionMapping.LOGIN_EXPIRE);
		}
		UserInfo userInfo = new UserInfo(sysUser);
		return userInfo;
	}

}
