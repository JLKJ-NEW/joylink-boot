package com.joylink.userms.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VdCode implements Serializable {
	
	private String vdcode;
	
	private long ts;

	public VdCode(String vdcode, long ts) {
		this.vdcode = vdcode;
		this.ts = ts;
	}

	public String getVdcode() {
		return vdcode;
	}

	public void setVdcode(String vdcode) {
		this.vdcode = vdcode;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}
	
	public boolean isInTime(int minutes) {
		return !isTimeout(minutes);
	}
	
	public boolean isTimeout(int minutes) {
		long dvalue = System.currentTimeMillis() - this.ts;
		if(dvalue < minutes*60*1000) {
			return false;
		} else {
			return true;
		}
	}
	
}
