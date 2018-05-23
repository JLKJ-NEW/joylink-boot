package com.joylink.userms.entity;

import java.io.Serializable;

import com.joylink.userms.vo.UserInfo;

/**
 * sys_user
 * 
 * @author
 */
public class SysUser implements Serializable {
	private Long id;

	/**
	 * 真实姓名
	 */
	private String name;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 国家码
	 */
	private String nationcode;

	/**
	 * 微信openId
	 */
	private String wxId;

	private static final long serialVersionUID = 1L;

	public SysUser() {
	}

	public SysUser(UserInfo userInfo) {
		this.id = userInfo.getId();
		this.name = userInfo.getName();
		this.nickname = userInfo.getNickname();
		this.mobile = userInfo.getMobile();
		this.nationcode = userInfo.getNationcode();
		this.wxId = userInfo.getWxId();
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

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		SysUser other = (SysUser) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getNickname() == null ? other.getNickname() == null
						: this.getNickname().equals(other.getNickname()))
				&& (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
				&& (this.getNationcode() == null ? other.getNationcode() == null
						: this.getNationcode().equals(other.getNationcode()))
				&& (this.getWxId() == null ? other.getWxId() == null : this.getWxId().equals(other.getWxId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
		result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
		result = prime * result + ((getNationcode() == null) ? 0 : getNationcode().hashCode());
		result = prime * result + ((getWxId() == null) ? 0 : getWxId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", nickname=").append(nickname);
		sb.append(", mobile=").append(mobile);
		sb.append(", nationcode=").append(nationcode);
		sb.append(", wxId=").append(wxId);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}