package com.joylink.userms.services;

import java.util.List;

import com.joylink.userms.vo.client.PageVO;
import com.joylink.userms.vo.client.RoleVO;

public interface ISysRoleService {

	PageVO queryPage(RoleVO roleVo, PageVO pageInfo);

	List<RoleVO> listAll();

}
