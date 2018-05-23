package com.joylink.userms.exceptions;

@SuppressWarnings("serial")
public class DBException extends RuntimeException {
	
	private Integer errcode;
	
	private String errmsg;
	
	public DBException(ExceptionMapping em) {
		super(em.getErrmsg());
		this.errcode = em.getErrcode();
		this.errmsg = em.getErrmsg();
	}
	
	public DBException(ExceptionMapping em, Throwable cause) {
		super(em.getErrmsg(), cause);
		this.errcode = em.getErrcode();
		this.errmsg = em.getErrmsg();
	}
	
	public DBException(Integer errcode, String errmsg) {
		super(errmsg);
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	
	public DBException(Integer errcode, String errmsg, Throwable cause) {
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
