package com.joylink.userms.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.joylink.userms.cache.WxAccessTokenCache;
import com.joylink.userms.configuration.configProp.WeChatConfig;
import com.joylink.userms.constants.WxConstants;
import com.joylink.userms.vo.wx.WxAccessToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetAccessTokenQuartz extends QuartzJobBean {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WeChatConfig weChatConfig;
	
	/**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	if(true) return;
        WxAccessToken wxAt = restTemplate.getForEntity(weChatConfig.getAccessTokenUrl(), WxAccessToken.class).getBody();
        if(StringUtils.isEmpty(wxAt.getAccess_token())) {
        	log.error(String.format("获取access_token任务失败: errcode=%d, errmsg=%s", wxAt.getErrcode(), wxAt.getErrmsg()));
        } else {
        	// 缓存access_token
        	log.info("获取access_token为: "+wxAt.toString());
        	WxAccessTokenCache.put(WxConstants.ACCESS_TOKEN, wxAt);
        }
    }
	
}
