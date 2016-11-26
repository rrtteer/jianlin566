package com.zjl.zjl_crm.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zjl.zjl_base.ResultInfo;
import com.zjl.zjl_base.exception.ParamException;

@RestControllerAdvice
public class ParamExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(ParamExceptionHandler.class);
	
	@ExceptionHandler(value = ParamException.class)
	public ResultInfo exceptionHandler(ParamException exception) {
		ResultInfo resultInfo = new ResultInfo();
		Integer errorCode = exception.getErrorCode(); // 获取异常的code
		String message = exception.getMessage(); // 获取异常的消息
		resultInfo.setResultCode(errorCode);
		resultInfo.setResult(message);
		logger.error("参数异常：{}", exception); // 打印异常
		return resultInfo;
	}
}
