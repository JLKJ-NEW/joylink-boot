package com.joylink.userms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joylink.userms.services.ISysUserService;
import com.joylink.userms.services.IWxApiService;
import com.joylink.userms.vo.CommonJsonResponse;
import com.joylink.userms.vo.UserInfo;
import com.joylink.userms.vo.wx.WxPageAccessToken;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/wxpat")
@Slf4j
public class WxPageAccessTokenController {
	
	@Autowired
	private IWxApiService iWxApiService;
	
	@Autowired
	private ISysUserService iSysUserService;
	
	/**
	 * 通过code获取页面access_token
	 * @param code
	 * @return
	 */
	@GetMapping(path="/getOpenid")
	public CommonJsonResponse getPageAccessToken(String code) {
		WxPageAccessToken pat = iWxApiService.getPageAccessToken(code);
		if(!StringUtils.isEmpty(pat.getOpenid())) {
			return CommonJsonResponse.newSuccessResponse(pat);
		} else {
			return CommonJsonResponse.newErrorResponse(pat.getErrcode(), pat.getErrmsg());
		}
	}
	
	@GetMapping(path="/getUserInfo")
	public CommonJsonResponse getUserInfo(String code) {
		WxPageAccessToken pat = iWxApiService.getPageAccessToken(code);
		log.info("page access token response: "+pat.toString());
		if(!StringUtils.isEmpty(pat.getOpenid())) {
			UserInfo user = this.iSysUserService.findUser(pat.getOpenid());
			return CommonJsonResponse.newSuccessResponse(user);
		}
		return CommonJsonResponse.newErrorResponse(pat.getErrcode(), pat.getErrmsg());
	}
	
}
