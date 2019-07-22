package com.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
	
	@ResponseBody
    @RequestMapping(value = "/AopTest")
    public String sayHello() {
        return "hello spring boot";
    }
	
	@RequestMapping("/first")  
    public Object first() {  
        return "first controller";  
    }  
  
    @RequestMapping("/doError")  
    public Object error() {  
        return 1 / 0;  
    }
	
}
