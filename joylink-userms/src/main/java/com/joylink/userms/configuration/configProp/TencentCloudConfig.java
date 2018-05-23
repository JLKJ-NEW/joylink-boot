package com.joylink.userms.configuration.configProp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="tencent-cloud")
public class TencentCloudConfig {
	
	private String domainUri;
	
	private String appId;
	
	private String appKey;
	
	private Integer vdcodeTpl;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	
	public String getDomainUri() {
		return domainUri;
	}

	public void setDomainUri(String domainUri) {
		this.domainUri = domainUri;
	}

	public Integer getVdcodeTpl() {
		return vdcodeTpl;
	}

	public void setVdcodeTpl(Integer vdcodeTpl) {
		this.vdcodeTpl = vdcodeTpl;
	}

	/**
	 * 获取指定模板发送短信的url
	 * @return
	 */
	public String getSendsmsUrl() {
		return new StringBuilder(this.domainUri)
					.append("/sendsms?sdkappid=").append(this.appId).toString();
	}
	
}
