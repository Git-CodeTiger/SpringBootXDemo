package com.sprint.ctrls;

import com.sprint.exception.MyException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RestController
public class TestCtrl {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		return "success is or not ?";
	}

	@RequestMapping("/throw-MyException")
	public void throwMyException() {
			throw new MyException("抛出自定义异常");
	}
}
