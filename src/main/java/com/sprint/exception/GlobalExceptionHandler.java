package com.sprint.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";
	
	public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public String myExceptionHandler(HttpServletRequest req, MyException e) throws Exception {
		logger.error("请求地址:" + req.getRequestURL());
		logger.error("错误信息:" + e);
		return "myException发生了异常";
	}

}
