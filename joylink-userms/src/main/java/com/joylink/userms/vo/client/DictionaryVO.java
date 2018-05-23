package com.joylink.userms.vo.client;

import java.io.Serializable;

import com.joylink.userms.entity.SysDictionary;

@SuppressWarnings("serial")
public class DictionaryVO implements Serializable {
	
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
    
    public DictionaryVO() {}
    
    public DictionaryVO(SysDictionary sysDic) {
    	this.id = sysDic.getId();
    	this.code = sysDic.getCode();
    	this.name = sysDic.getName();
    	this.status = sysDic.getStatus();
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
    
}
