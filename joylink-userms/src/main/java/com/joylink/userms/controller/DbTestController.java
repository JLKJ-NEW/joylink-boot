package com.joylink.userms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joylink.userms.dao.SysUserMapper;
import com.joylink.userms.entity.SysUser;
import com.joylink.userms.vo.CommonJsonResponse;

@RestController
@RequestMapping(path="/api/dbtest")
public class DbTestController {
	
	@Autowired
	private SysUserMapper wxUserMapper;
	
	@PostMapping(path="/add")
	public CommonJsonResponse insert() {
		SysUser wxUser = new SysUser();
		wxUser.setName("测试");
		wxUser.setMobile("13333333333");
		wxUser.setWxId("jsajfljsdaji1");
		wxUserMapper.insert(wxUser);
		return CommonJsonResponse.newSuccessResponse();
	}
	
}
