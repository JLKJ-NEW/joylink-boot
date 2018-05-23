package com.joylink.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joylink.userms.services.ISysRoleService;
import com.joylink.userms.vo.CommonJsonResponse;
import com.joylink.userms.vo.UserInfo;
import com.joylink.userms.vo.client.PageVO;
import com.joylink.userms.vo.client.RoleVO;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private ISysRoleService iSysRoleService;
	
	@GetMapping(path="/list")
	public CommonJsonResponse page(RoleVO roleVo, PageVO pageInfo) {
		PageVO page = this.iSysRoleService.queryPage(roleVo, pageInfo);
		return CommonJsonResponse.newSuccessResponse(page);
	}
	
	@GetMapping(path="/all")
	public CommonJsonResponse listAll() {
		List<RoleVO> list = this.iSysRoleService.listAll();
		return CommonJsonResponse.newSuccessResponse(list);
	}
	
	@PostMapping(path="/create")
	public CommonJsonResponse create(@RequestBody UserInfo userInfo, @RequestParam(name="vdcode", required=true) String vdcode) {
		return CommonJsonResponse.newSuccessResponse();
	}
	
}
