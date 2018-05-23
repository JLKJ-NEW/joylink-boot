package com.joylink.userms.vo.tc;

@SuppressWarnings("serial")
public class TcSendsmsResp extends TcBaseResp {
	
	private String ext;
	
	private Integer fee;
	
	private String sid;

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
