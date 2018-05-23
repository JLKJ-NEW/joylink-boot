package com.joylink.userms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joylink.userms.services.IAuthenticateService;
import com.joylink.userms.vo.CommonJsonResponse;
import com.joylink.userms.vo.UserInfo;
import com.joylink.userms.vo.client.LoginVO;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	private IAuthenticateService iAuthenticateService;
	
	@GetMapping()
	public CommonJsonResponse login(String wxId, String sessionId) {
		iAuthenticateService.login(wxId, sessionId);
		return CommonJsonResponse.newSuccessResponse();
	}
	
	@GetMapping(path="/logout")
	public CommonJsonResponse logout(String wxId) {
		return CommonJsonResponse.newSuccessResponse();
	}
	
	@GetMapping(path="/getUrl")
	public CommonJsonResponse getLoginUrl(HttpServletRequest request) {
		LoginVO loginVo = iAuthenticateService.getLoginUrl(request.getSession().getId());
		return CommonJsonResponse.newSuccessResponse(loginVo);
	}
	
	@GetMapping(path="/getToken")
	public CommonJsonResponse getToken(String sessionId) {
		LoginVO loginVo = iAuthenticateService.getToken(sessionId);
		return CommonJsonResponse.newSuccessResponse(loginVo);
	}
	
	/**
	 * 获取登陆用户信息 - 通过token
	 * @param token
	 * @return
	 */
	@GetMapping(path="/getUserInfo")
	public CommonJsonResponse getLoginUserInfo(String token) {
		UserInfo userInfo = this.iAuthenticateService.getUserInfo(token);
		return CommonJsonResponse.newSuccessResponse(userInfo);
	}
	
}
