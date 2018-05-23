package com.joylink.userms.vo;

import java.io.Serializable;

import com.joylink.userms.constants.ResponseConsts;

@SuppressWarnings("serial")
public class CommonJsonResponse implements Serializable {
	
	private Integer code;
	
	private String message;
	
	private Object data;
	
	/**
	 * 构造一个没有数据的消息
	 * @param respConst
	 */
	private CommonJsonResponse(ResponseConsts respConst) {
		this.code = respConst.getCode();
		this.message = respConst.getMsg();
	}
	
	/**
	 * 构造成功返回数据对象
	 * @param data
	 */
	private CommonJsonResponse(Object data) {
		this.code = ResponseConsts.SUCCESS.getCode();
		this.message = ResponseConsts.SUCCESS.getMsg();
		this.data = data;
	}
	
	public CommonJsonResponse(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	/**
	 * 返回通用成功对象
	 * @return
	 */
	public static CommonJsonResponse newSuccessResponse() {
		return new CommonJsonResponse(ResponseConsts.SUCCESS);
	}
	
	/**
	 * 成功返回数据对象
	 * @param data
	 * @return
	 */
	public static CommonJsonResponse newSuccessResponse(Object data) {
		return new CommonJsonResponse(data);
	}
	
	/**
	 * 返回失败对象
	 * @return
	 */
	public static CommonJsonResponse newFaildResponse(ResponseConsts respConst) {
		return new CommonJsonResponse(respConst);
	}
	
	/**
	 * 返回通用异常对象
	 * @return
	 */
	public static CommonJsonResponse newErrorResponse() {
		return new CommonJsonResponse(ResponseConsts.ERROR);
	}
	
	public static CommonJsonResponse newErrorResponse(int code, String msg) {
		return new CommonJsonResponse(code, msg);
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CommonJsonResponse [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
}
