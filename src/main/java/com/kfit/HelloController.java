package com.kfit;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("hello")
	public String hello() {
		return "hello springboot";
	}

	@RequestMapping("/getById")
	public String getById() {
		OperateAspect operateAspect = new OperateAspect();
		operateAspect.annotationPointCut();
		return "hello springboot";
	}
	
	 
	 @Test(value="睡觉",name="张三",age="20")
	    @RequestMapping(value = "/say")
	    public String sayHello() {
	        System.out.println("吃饭");
	        return "hello spring boot";
	    }
	
	
}
