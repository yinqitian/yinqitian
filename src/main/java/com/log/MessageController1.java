package com.log;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MessageController1 {

	@MessageInfo(success="登录成功",tips="正在登录")
	    @RequestMapping(value = "/test")
	    public String sayHello() {
	        System.out.println("欢迎使用****操作系统");
	        return "hello spring boot";
	    }
}
