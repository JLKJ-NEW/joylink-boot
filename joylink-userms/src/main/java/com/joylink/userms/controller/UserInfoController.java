package com.joylink.userms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joylink.userms.services.ISysUserService;
import com.joylink.userms.vo.CommonJsonResponse;
import com.joylink.userms.vo.UserInfo;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoController {
	
	@Autowired
	private ISysUserService iSysUserService;
	
	@GetMapping(path="/getByOpenId")
	public CommonJsonResponse getUserInfoByOpenId(String openId) {
		return CommonJsonResponse.newErrorResponse(30001, "sdlfjal");
	}
	
	@PostMapping(path="/create")
	public CommonJsonResponse create(@RequestBody @Validated UserInfo userInfo, @RequestParam(name="vdcode", required=true) String vdcode) {
		this.iSysUserService.createUser(userInfo, vdcode);
		return CommonJsonResponse.newSuccessResponse();
	}
	
}
