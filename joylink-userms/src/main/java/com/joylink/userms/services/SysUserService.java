package com.joylink.userms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.joylink.userms.cache.ICacheManager;
import com.joylink.userms.constants.BusinessConsts;
import com.joylink.userms.dao.SysUserMapper;
import com.joylink.userms.entity.SysUser;
import com.joylink.userms.entity.SysUserExample;
import com.joylink.userms.exceptions.BusinessException;
import com.joylink.userms.exceptions.DBException;
import com.joylink.userms.exceptions.ExceptionMapping;
import com.joylink.userms.vo.UserInfo;
import com.joylink.userms.vo.VdCode;

@Service
public class SysUserService implements ISysUserService {
	/**
	 * 默认中国码
	 */
	private static final String NATION_CODE = "86";
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private ICacheManager iCacheManager;
	
	@Override
	public void createUser(UserInfo userInfo, String vdcode) {
		if(StringUtils.isEmpty(userInfo.getNationcode())) {
			userInfo.setNationcode(NATION_CODE);
		}
		// 验证码校验
		VdCode object = (VdCode) iCacheManager.get(userInfo.getNationcode()+userInfo.getMobile());
		if(null == object || object.isTimeout(BusinessConsts.VDCODE_TIMEOUT)) {
			throw new BusinessException(ExceptionMapping.VDCODE_EXPIRE);
		} else if(!object.getVdcode().equals(vdcode)) {
			throw new BusinessException(ExceptionMapping.VDCODE_INCORRECT);
		}
		// 验证码校验正确
		SysUserExample example = new SysUserExample();
		example.createCriteria().andMobileEqualTo(userInfo.getMobile());
		List<SysUser> mUser = this.sysUserMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(mUser)) {
			throw new DBException(ExceptionMapping.DATA_EXISTS);
		}
		example = new SysUserExample();
		example.createCriteria().andWxIdEqualTo(userInfo.getWxId());
		List<SysUser> wiUser = this.sysUserMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(wiUser)) {
			throw new DBException(ExceptionMapping.DATA_EXISTS);
		}
		SysUser user = new SysUser(userInfo);
		this.sysUserMapper.insert(user);
	}

	@Override
	public UserInfo findUser(String openid) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andWxIdEqualTo(openid);
		List<SysUser> list = this.sysUserMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)) {
			throw new DBException(ExceptionMapping.DATA_NOT_EXIST);
		}
		UserInfo userInfo = new UserInfo(list.get(0));
		return userInfo;
	}

}
