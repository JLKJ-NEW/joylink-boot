package com.joylink.userms.services;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.joylink.userms.configuration.configProp.TencentCloudConfig;
import com.joylink.userms.util.EncryptUtil;
import com.joylink.userms.util.RandomGenerator;
import com.joylink.userms.vo.InternationalMobile;
import com.joylink.userms.vo.SmsResponse;
import com.joylink.userms.vo.tc.TcSendsmsResp;
import com.joylink.userms.vo.tc.TcSmsReq;

import lombok.extern.slf4j.Slf4j;

/**
 * 腾讯云短信发送服务
 * 
 * @author sheng
 *
 */
@Service
@Slf4j
public class TcSmsService implements ISmsService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TencentCloudConfig tencentCloudConfig;

	@Override
	public SmsResponse sendToOneOnTpl(int tplId, String mobile, String nationcode, List<String> params, long ts) {
		SmsResponse sr = new SmsResponse();
		sr.setMobile(mobile);
		sr.setNationcode(nationcode);
		String random = RandomGenerator.getByLen(4);
		long time = ts / 1000; // 单位 秒
		String url = tencentCloudConfig.getSendsmsUrl() + "&random=" + random;
		String enStr = String.format("appkey=%s&random=%s&time=%s&mobile=%s", tencentCloudConfig.getAppKey(), random,
				time + "", mobile);
		String sig = EncryptUtil.sha256(enStr);
		TcSmsReq reqObj = new TcSmsReq();
		reqObj.setExt("");
		reqObj.setExtend("");
		reqObj.setTime(time);
		reqObj.setTpl_id(tplId);
		reqObj.setTel(new InternationalMobile(mobile, nationcode));
		reqObj.setParams(params);
		reqObj.setSig(sig);
		JSONObject jo = new JSONObject(reqObj);
		String reqJson = jo.toString();
		log.info("发送短信请求: " + reqJson);
		// 发送短信请求
		TcSendsmsResp resp = restTemplate.postForObject(url, reqJson, TcSendsmsResp.class);
		sr.setResult(resp.getResult());
		sr.setErrmsg(resp.getErrmsg());
		sr.setSid(resp.getSid());
		return sr;
	}

}
