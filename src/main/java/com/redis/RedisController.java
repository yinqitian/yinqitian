package com.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate=null;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate=null;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("")
	@ResponseBody
	public Map<String, Object> testStringAndHash(){
		redisTemplate.opsForValue().set("key1", "value1");
		redisTemplate.opsForValue().set("int_key", "1");
		stringRedisTemplate.opsForValue().set("int", "1");
		stringRedisTemplate.opsForValue().increment("int", 1);
		Jedis jedis=(Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		//jedis.decr();
		
		
		
		
		return null;
		
	} 
	
	

}
