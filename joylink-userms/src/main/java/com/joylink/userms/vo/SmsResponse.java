package com.joylink.userms.vo;

/**
 * 短信发送响应消息
 * @author sheng
 *
 */
public class SmsResponse {
	
	private Integer result;
	
	private String errmsg;
	
	private String sid;
	
	private String mobile;
	
	private String nationcode;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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
	
}
