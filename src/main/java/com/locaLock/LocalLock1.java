package com.locaLock;

import java.lang.annotation.*;

/**
 * 锁的注解
 *
 * @author 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock1 {

    /**
     * @author 
     */
    String key() default "";

    /**
     * 过期时间 TODO 由于用的 guava 暂时就忽略这属性吧 集成 redis 需要用到
     *
     * @author 
     */
    int expire() default 5;
}
