package com.joylink.userms.constants;

public enum ResponseConsts {
	
	SUCCESS(200, "成功"),
	FAILD(300, "失败"),
	ERROR(500, "未知错误"),
	VALIDATE_ERROR(501, "");
	
	private ResponseConsts(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private Integer code;
	
	private String msg;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
