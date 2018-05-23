package com.joylink.userms.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {
	
	private Integer errcode;
	
	private String errmsg;
	
	public BusinessException(ExceptionMapping em) {
		super(em.getErrmsg());
		this.errcode = em.getErrcode();
		this.errmsg = em.getErrmsg();
	}
	
	public BusinessException(ExceptionMapping em, Throwable cause) {
		super(em.getErrmsg(), cause);
		this.errcode = em.getErrcode();
		this.errmsg = em.getErrmsg();
	}
	
	public BusinessException(Integer errcode, String errmsg) {
		super(errmsg);
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	
	public BusinessException(Integer errcode, String errmsg, Throwable cause) {
		super(errmsg, cause);
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

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
	
}
