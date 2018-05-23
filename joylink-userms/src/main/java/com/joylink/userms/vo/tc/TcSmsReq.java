package com.joylink.userms.vo.tc;

import java.io.Serializable;
import java.util.List;

import com.joylink.userms.vo.InternationalMobile;

@SuppressWarnings("serial")
public class TcSmsReq implements Serializable {
	
	private String ext;
	
	private String extend;
	
	private Long time;
	
	private String sig;
	
	private String sign;
	
	private Integer tpl_id;
	
	private InternationalMobile tel;
	
	private List<String> params;

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getTpl_id() {
		return tpl_id;
	}

	public void setTpl_id(Integer tpl_id) {
		this.tpl_id = tpl_id;
	}

	public InternationalMobile getTel() {
		return tel;
	}

	public void setTel(InternationalMobile tel) {
		this.tel = tel;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}
	
}
