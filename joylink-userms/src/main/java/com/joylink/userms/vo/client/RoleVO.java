package com.joylink.userms.vo.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.joylink.userms.entity.SysRole;

@SuppressWarnings("serial")
public class RoleVO implements Serializable {
	private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：0-禁用，1-启用
     */
    private String status;
    
    public RoleVO() {}
    
    public RoleVO(SysRole sysRole) {
    	this.id = sysRole.getId();
    	this.code = sysRole.getCode();
    	this.name = sysRole.getName();
    	this.status = sysRole.getStatus();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List<RoleVO> revertList(List<SysRole> result) {
		List<RoleVO> list = new ArrayList<>();
		if(!CollectionUtils.isEmpty(result)) {
			result.forEach(sysRole -> {
				list.add(new RoleVO(sysRole));
			});
		}
		return list;
	}

	public static PageVO newPage(Page<SysRole> page) {
		PageVO newPage = new PageVO(page.getPageNum(), page.getPageSize(), page.getTotal());
		newPage.setList(page.getResult());
		return newPage;
	}
    
}
