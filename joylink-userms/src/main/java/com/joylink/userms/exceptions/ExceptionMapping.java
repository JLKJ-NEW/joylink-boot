package com.joylink.userms.exceptions;

public enum ExceptionMapping {
	
	DATA_EXISTS(20001, "data already exist!"),
	
	DATA_NOT_EXIST(30001, "data not exist!"),
	
	VDCODE_EXPIRE(40001, "vdcode expire"),
	VDCODE_INCORRECT(40002, "vdcode incorrect"),
	CLIENT_LOGIN_INVALID(40003, "client login status invalid"),
	LOGIN_EXPIRE(40004, "login expire"),
	
	ARGUMENT_ILLEGAL(500001, "argument illegal")
	
	;
	
	private ExceptionMapping(int errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	
	private int errcode;
	
	private String errmsg;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
