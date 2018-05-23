package com.joylink.userms.configuration.configProp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="wechat")
public class WeChatConfig {
	
	private String domainUri;
	
	private String appId;
	
	private String appSecret;
	
	private String clientLoginUrl;

	public String getDomainUri() {
		return domainUri;
	}

	public void setDomainUri(String domainUri) {
		this.domainUri = domainUri;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
	public String getClientLoginUrl() {
		return clientLoginUrl;
	}

	public void setClientLoginUrl(String clientLoginUrl) {
		this.clientLoginUrl = clientLoginUrl;
	}

	/**
	 * 获取access-token的url
	 * @return
	 */
	public String getAccessTokenUrl() {
		return new StringBuilder(this.domainUri)
					.append("/cgi-bin/token?grant_type=client_credential")
					.append("&appid=").append(this.appId)
					.append("&secret=").append(this.appSecret).toString();
	}
	
	/**
	 * 创建menu的url
	 * @return
	 */
	public String getMenuCreateUrl() {
		return new StringBuilder(this.domainUri)
					.append("/cgi-bin/menu/create?access_token={1}").toString();
	}
	
	/**
	 * 获取页面access_token的url
	 * @return
	 */
	public String getPageAccessTokenUrl(String code) {
		return new StringBuilder(this.domainUri)
					.append("/sns/oauth2/access_token?appid=").append(this.appId)
					.append("&secret=").append(this.appSecret)
					.append("&code=").append(code)
					.append("&grant_type=authorization_code").toString();
	}
	
}
