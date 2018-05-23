package com.joylink.userms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.joylink.userms.constants.BusinessConsts;
import com.joylink.userms.dao.SysRoleMapper;
import com.joylink.userms.entity.SysRole;
import com.joylink.userms.entity.SysRoleExample;
import com.joylink.userms.entity.SysRoleExample.Criteria;
import com.joylink.userms.vo.client.PageVO;
import com.joylink.userms.vo.client.RoleVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysRoleService implements ISysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public PageVO queryPage(RoleVO roleVo, PageVO pageInfo) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 设置条件
		SysRoleExample example = new SysRoleExample();
		Criteria or1 = example.createCriteria();
		if(StringUtil.isNotEmpty(roleVo.getCode())) {
			or1.andCodeLike(String.format("%%%s%%", roleVo.getCode()));
		}
		if(StringUtil.isNotEmpty(roleVo.getName())) {
			or1.andNameLike(String.format("%%%s%%", roleVo.getName()));
		}
		if(StringUtil.isNotEmpty(roleVo.getStatus())) {
			or1.andStatusEqualTo(roleVo.getStatus());
		}
		// 查询
		Page<SysRole> page = (Page<SysRole>) this.sysRoleMapper.selectByExample(example);
		// 数据转换
		PageVO resultPage = RoleVO.newPage(page);
		return resultPage;
	}

	@Override
	public List<RoleVO> listAll() {
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andStatusEqualTo(BusinessConsts.STATUS_USE);
		List<SysRole> list = this.sysRoleMapper.selectByExample(example);
		List<RoleVO> resultList = RoleVO.revertList(list);
		return resultList;
	}

}
