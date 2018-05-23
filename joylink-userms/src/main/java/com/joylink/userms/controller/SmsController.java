package com.joylink.userms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joylink.userms.cache.ICacheManager;
import com.joylink.userms.configuration.configProp.TencentCloudConfig;
import com.joylink.userms.services.ISmsService;
import com.joylink.userms.util.RandomGenerator;
import com.joylink.userms.vo.CommonJsonResponse;
import com.joylink.userms.vo.SmsResponse;
import com.joylink.userms.vo.VdCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 短信服务
 * @author sheng
 *
 */
@RestController
@RequestMapping("/api/sms")
@Slf4j
public class SmsController {
	
	/**
	 * 电话号码 国家码
	 */
	private static final String NATION_CODE = "86";
	
	/**
	 * 短信验证码超时时间
	 */
	public static final int VDCODE_TIMEOUT = 5;
	
	@Autowired
	private ISmsService iSmsService;
	
	@Autowired
	private TencentCloudConfig tencentCloudConfig;
	
	@Autowired
	private ICacheManager iCacheManager;
	
	@PostMapping(path="/sendVdcode")
	public CommonJsonResponse sendVdcodeTo(@RequestBody Map<String, String> map) {
		String nationcode = map.get("nationcode");
		String mobile = map.get("mobile");
		if(StringUtils.isEmpty(nationcode)) {
			nationcode = NATION_CODE;
		}
		String vdcode = RandomGenerator.getByLen(4);
		long ts = System.currentTimeMillis();
		List<String> params = new ArrayList<>();
		params.add(vdcode);
		params.add(VDCODE_TIMEOUT+"");
		SmsResponse resp = iSmsService.sendToOneOnTpl(tencentCloudConfig.getVdcodeTpl(), mobile, nationcode, params, ts);
		if(resp.getResult().intValue() == 0) {
			// 成功
			iCacheManager.put(nationcode+mobile, new VdCode(vdcode, ts));
			return CommonJsonResponse.newSuccessResponse(vdcode);
		} else {
			return CommonJsonResponse.newSuccessResponse(resp);
		}
	}
	
	@PostMapping(path="/addCache")
	public CommonJsonResponse addCache(@RequestBody Map<String, String> map) {
		String nationcode = map.get("nationcode");
		String mobile = map.get("mobile");
		String vdcode = RandomGenerator.getByLen(4);
		long ts = System.currentTimeMillis();
		iCacheManager.put(nationcode+mobile, new VdCode(vdcode, ts));
		return CommonJsonResponse.newSuccessResponse(vdcode);
	}
	
	@PostMapping(path="/getCache")
	public CommonJsonResponse getCache(@RequestBody Map<String, String> map) {
		String nationcode = map.get("nationcode");
		String mobile = map.get("mobile");
		VdCode object = (VdCode) iCacheManager.get(nationcode+mobile);
		if(null != object) {
			log.info("未超时: " + object.isInTime(VDCODE_TIMEOUT));
		}
		return CommonJsonResponse.newSuccessResponse(object);
	}
	
}
