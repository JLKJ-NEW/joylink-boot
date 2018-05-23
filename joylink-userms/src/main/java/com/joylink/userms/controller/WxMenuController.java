package com.joylink.userms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.joylink.userms.cache.WxAccessTokenCache;
import com.joylink.userms.configuration.configProp.WeChatConfig;
import com.joylink.userms.vo.CommonJsonResponse;
import com.joylink.userms.vo.wx.WxBaseResp;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/wxmenu")
@Slf4j
public class WxMenuController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WeChatConfig weChatConfig;
	
	@PostMapping(path="/create")
	public CommonJsonResponse createWxmenu(@RequestBody String menuJson) {
		WxBaseResp body = restTemplate.postForObject(weChatConfig.getMenuCreateUrl(), menuJson, WxBaseResp.class,
						WxAccessTokenCache.getWxAccessTokenString());
		log.info("创建菜单返回结果: "+body.toString());
		return CommonJsonResponse.newSuccessResponse(body);
	}
	
}
