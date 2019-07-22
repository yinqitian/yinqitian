package com.kfit;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperateAspect {

	 @Pointcut("@annotation(com.kfit.Test)")
     public void annotationPointCut() {
      System.out.println("hello world");
     }
	 
	 @Before("annotationPointCut()")
	    public void beforePointcut(JoinPoint joinPoint) {
	        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
	        Method method = methodSignature.getMethod();
	        Test annotation = method.getAnnotation(Test.class);
	        String value = annotation.value();
	        String name  = annotation.name();
	        String age  = annotation.age();
	        System.out.println("姓名"+"："+name);
	        System.out.println("年龄"+"："+age);
	        System.out.println("准备"+"："+value);
	    }

	    @After("annotationPointCut()")
	    public void afterPointcut(JoinPoint joinPoint) {
	        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
	        Method method = methodSignature.getMethod();
	        Test annotation = method.getAnnotation(Test.class);
	        String value = annotation.value();
	        System.out.println("结束"+"："+value);
	    }
	
	 

}
