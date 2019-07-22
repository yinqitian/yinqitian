package com.log;

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

@Aspect//作用是把当前类标识为一个切面供容器读取 
@Component
public class Annotation {

	/*定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码. 
               使用 @Pointcut 来声明切入点表达式.
               后面的其他通知直接使用方法名来引用当前的切入点表达式.*/
	 @Pointcut("@annotation(com.log.MessageInfo)")
     public void annotationPointCut1() {
      //System.out.println("hello world");
     }
	 
	 @Before("annotationPointCut1()")//前置通知
	    public void beforePointcut(JoinPoint joinPoint) {
	        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
	        Method method = methodSignature.getMethod();
	        MessageInfo annotation = method.getAnnotation(MessageInfo.class);
	        String tips= annotation.tips();
	        System.out.println("准备："+tips);
	    }

	    @After("annotationPointCut1()")//后置通知
	    public void afterPointcut(JoinPoint joinPoint) {
	        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
	        Method method = methodSignature.getMethod();
	        MessageInfo annotation = method.getAnnotation(MessageInfo.class);
	        String success= annotation.success();
	        System.out.println("完成登录："+success);
	    }
	
	 

}
