package com.joylink.userms.vo.tc;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TcBaseResp implements Serializable {
	
	private Integer result;
	
	private String errmsg;

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
	
}
