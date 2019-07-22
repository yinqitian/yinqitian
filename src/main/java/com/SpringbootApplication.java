package com;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cacheLock.CacheKeyGenerator;
import com.cacheLock.LockKeyGenerator;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringbootApplication {
    public static void main( String[] args ){
    	
        SpringApplication.run(SpringbootApplication.class, args);
        
    }
    
    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }
   

}
