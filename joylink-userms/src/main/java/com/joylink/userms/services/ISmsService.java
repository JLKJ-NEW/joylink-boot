package com.joylink.userms.services;

import java.util.List;

import com.joylink.userms.vo.SmsResponse;

/**
 * 短信服务接口
 * @author sheng
 *
 */
public interface ISmsService {
	
	/**
	 * 使用模板发送一条短信
	 * @param tplId - 模板id
	 * @param mobile - 电话号
	 * @param nationcode - 国家码
	 * @param params - 模板内参数列表
	 * @param ts - 发送时间戳
	 * @return
	 */
	public SmsResponse sendToOneOnTpl(int tplId, String mobile, String nationcode, List<String> params, long ts);
	
}
