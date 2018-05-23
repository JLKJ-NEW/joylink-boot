package com.joylink.userms.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InternationalMobile implements Serializable {
	
	private String mobile;
	
	private String nationcode;
	
	public InternationalMobile(String mobile, String nationcode) {
		this.mobile = mobile;
		this.nationcode = nationcode;
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
