package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//切面类注解
@Aspect
@Component
public class AopTest {

	private static Logger logger = Logger.getLogger(AopTest.class);

	// 配置切点
	@Pointcut("execution(* com.aop..*(..))")
	public void log() {
	}

//	@Before("log()") // 前置通知
//	public void beforeExcution(JoinPoint joinPoint) {
//		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.getRequestAttributes();
//		HttpServletRequest request = requestAttributes.getRequest();
//		logger.info("前置通知开启=====================");
//
//		logger.info("URL : " + request.getRequestURL().toString());
//		logger.info("HTTP_METHOD : " + request.getMethod());
//		logger.info("IP : " + request.getRemoteAddr());
//		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
//				+ joinPoint.getSignature().getName());
//		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//
//		logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//
//		logger.info("前置通知结束=====================");
//	}
//
//	@AfterReturning(returning = "ret", pointcut = "log()") // 后置返回
//	public void doAfterReturning(Object ret) throws Throwable {
//		// 处理完请求，返回内容
//		logger.info("RESPONSE : " + ret);
//	}

	
	  @Before("log()") public void deBefore(JoinPoint joinPoint) throws Throwable {
	  // 接收到请求，记录请求内容 
      ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	  HttpServletRequest request = attributes.getRequest(); // 记录下请求内容
	  System.out.println("前置通知"); System.out.println("URL : " +
	  request.getRequestURL().toString()); System.out.println("HTTP_METHOD : " +
	  request.getMethod()); System.out.println("IP : " + request.getRemoteAddr());
	  System.out.println("CLASS_METHOD : " +
	  joinPoint.getSignature().getDeclaringTypeName() + "." +
	  joinPoint.getSignature().getName()); System.out.println("ARGS : " +
	  Arrays.toString(joinPoint.getArgs()));
	  
	  }
	  
	  @AfterReturning(returning = "ret", pointcut = "log()") public void
	  doAfterReturning(Object ret) throws Throwable { // 处理完请求，返回内容
	  System.out.println("方法的返回值 : " + ret); }
	  
	  //后置异常通知
	  
	  @AfterThrowing("log()") public void throwss(JoinPoint jp){
	  System.out.println("方法异常时执行....."); }
	  
	  //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
	  
	  @After("log()") public void after(JoinPoint jp){
	  System.out.println("方法最后执行....."); }
	  
	  //环绕通知,环绕增强，相当于MethodInterceptor
	  
	  @Around("log()") public Object arround(ProceedingJoinPoint pjp) {
	  System.out.println("方法环绕start....."); try { Object o = pjp.proceed();
	  System.out.println("方法环绕proceed，结果是 :" + o); return o; } catch (Throwable e)
	  { e.printStackTrace(); return null; } }
	 

}
