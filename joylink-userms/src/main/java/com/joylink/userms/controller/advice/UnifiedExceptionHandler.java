package com.joylink.userms.controller.advice;

import java.util.List;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joylink.userms.constants.ResponseConsts;
import com.joylink.userms.exceptions.BusinessException;
import com.joylink.userms.exceptions.DBException;
import com.joylink.userms.vo.CommonJsonResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

	/**
	 * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public CommonJsonResponse exceptionGet(Exception e) {
		if (e instanceof DBException) {
			// 自定义数据库相关异常处理
			DBException dbException = (DBException) e;
			log.error("【数据操作异常】{}", e);
			return CommonJsonResponse.newErrorResponse(dbException.getErrcode(), dbException.getErrmsg());
		} else if(e instanceof MethodArgumentNotValidException) {
			// 参数验证异常处理
			MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
			List<ObjectError> errorList = validException.getBindingResult().getAllErrors();
			StringBuffer sb = new StringBuffer();
			errorList.forEach(error -> {
				sb.append(error.getDefaultMessage()).append("; ");
			});
			log.error("【参数校验异常】{}", e);
			return CommonJsonResponse.newErrorResponse(ResponseConsts.VALIDATE_ERROR.getCode(), sb.toString());
		} else if(e instanceof BusinessException) {
			BusinessException bizException = (BusinessException) e;
			log.error("【业务异常】{}", e);
			return CommonJsonResponse.newErrorResponse(bizException.getErrcode(), bizException.getErrmsg());
		}
		
		log.error("【系统异常】{}", e);
		return CommonJsonResponse.newErrorResponse();
	}

}
