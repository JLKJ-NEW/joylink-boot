package com.joylink.userms.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.joylink.userms.entity.SysUser;

@SuppressWarnings("serial")
public class UserInfo implements Serializable {
	private Long id;

    /**
     * 真实姓名
     */
	@NotBlank(message="{userInfo.name.notBlank}")
    private String name;

    /**
     * 昵称
     */
	@NotBlank(message="{userInfo.nickname.notBlank}")
    private String nickname;

    /**
     * 手机号
     */
	@NotBlank(message="{userInfo.mobile.notBlank}")
	@Pattern(regexp="^1[34578][0-9]{9}$", message="{userInfo.mobile.invalid}")
    private String mobile;

    /**
     * 国家码
     */
    private String nationcode;

    /**
     * 微信openId
     */
    @NotBlank(message="{userInfo.wxId.notBlank}")
    private String wxId;
    
    public UserInfo() {}
    
	public UserInfo(SysUser sysUser) {
		this.id = sysUser.getId();
		this.name = sysUser.getName();
		this.nickname = sysUser.getNickname();
		this.mobile = sysUser.getMobile();
		this.nationcode = sysUser.getNationcode();
		this.wxId = sysUser.getWxId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNationcode() {
		return nationcode;
	}

	public void setNationcode(String nationcode) {
		this.nationcode = nationcode;
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

}
