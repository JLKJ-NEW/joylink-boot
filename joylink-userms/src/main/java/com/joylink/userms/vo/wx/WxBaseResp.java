package com.joylink.userms.vo.wx;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WxBaseResp implements Serializable {
	
	private Integer errcode;
	
	private String errmsg;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "WxBaseResp [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	
}
