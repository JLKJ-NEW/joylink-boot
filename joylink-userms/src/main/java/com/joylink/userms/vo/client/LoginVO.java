package com.joylink.userms.vo.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginVO implements Serializable {
	
	private String url;
	
	private String sessionId;
	
	private String status;
	
	private String token;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
