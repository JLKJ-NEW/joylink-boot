package com.joylink.userms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.joylink.userms.entity.SysDictionary;
import com.joylink.userms.exceptions.DBException;
import com.joylink.userms.services.ISysDictionaryService;
import com.joylink.userms.vo.CommonJsonResponse;
import com.joylink.userms.vo.client.DictionaryVO;
import com.joylink.userms.vo.client.PageVO;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {
	
	@Autowired
	private ISysDictionaryService iSysDictionaryService;
	
	@GetMapping(path="/list")
	public CommonJsonResponse queryDic(DictionaryVO dicVO, PageVO pageInfo) {
		Page<SysDictionary> page = this.iSysDictionaryService.queryPage(dicVO, pageInfo);
		return CommonJsonResponse.newSuccessResponse(page);
	}
	
	@PostMapping(path="/create")
	public CommonJsonResponse createDic(@RequestBody DictionaryVO dicVO) throws DBException {
		this.iSysDictionaryService.createDic(dicVO);
		return CommonJsonResponse.newSuccessResponse();
	}
	
}
