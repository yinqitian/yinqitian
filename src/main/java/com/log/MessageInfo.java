package com.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明可以使用该注解的目标类型
@Target(value= {ElementType.METHOD,ElementType.TYPE})
// 声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
//指明修饰的注解，可以被例如javadoc此类的工具文档化，只负责标记，没有成员取值。
@Documented

//@interface意思是声明一个注解，方法名对应参数名，返回值类型对应参数类型。
public @interface MessageInfo {

	//声明注解成员
	public String success() default "";
	
	public String fail() default "";
	
	public String tips() default "";
}
