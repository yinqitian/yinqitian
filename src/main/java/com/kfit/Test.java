package com.kfit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(value={ElementType.METHOD, ElementType.TYPE})
//@Target注解:他的作用是将这个注解放在什么地方，比如类上、方法上、构造器上、变量上等，他的值是一个枚举类型的。 
//1、ElementType.CONSTRUCTOR:用于描述构造器 
//2、ElementType.FIELD:成员变量、对象、属性（包括enum实例） 
//3、ElementType.LOCAL_VARIABLE:用于描述局部变量 
//4、ElementType.METHOD:用于描述方法 
//5、ElementType.PACKAGE:用于描述包 
//6、ElementType.PARAMETER:用于描述参数 
//7、ElementType.TYPE:用于描述类、接口(包括注解类型) 或enum声明 
//也就是说你使用这个注解的时候是告诉你这个注解可以放在什么位置。

@Retention(RetentionPolicy.RUNTIME)
//@Retention 注解
//@Retention 注解:他的作用是为了说明这个注解的生命周期，在注解中有三个生命周期 
//1、RetentionPolicy.RUNTIME : 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。我们自定义的注解通常使用这种方式。 
//2、RetentionPolicy.CLASS : 在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式 
//3、RetentionPolicy.SOURCE : 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。 
//我们在自定义使用过程中基本上使用的是第一种 
//@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。 
//@Documented–一个简单的Annotations标记注解，表示是否将注解信息添加在java文档中。 
//我们也将完了这几个元注解，接下来我们要新建一个注解 
//首先在esclipse中新建一个annimation，然后会生成一个@类名的注解类，然后在添加上元注解，


public @interface Test {
	
	
    public String value() default "";
    
    public String name() default "";
    
    public String age()  default "";
    


}

