package com.joylink.userms.controller.advice;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RequestInfo implements Serializable {
	
	private String url;
	
	private String methodType;
	
	private String ip;
	
	private String classMethod;
	
	private String args;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClassMethod() {
		return classMethod;
	}

	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}
	
}
