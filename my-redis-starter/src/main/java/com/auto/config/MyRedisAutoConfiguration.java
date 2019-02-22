package com.auto.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MyRedisProperties.class)
@EnableConfigurationProperties(MyRedisProperties.class)
public class MyRedisAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean(name="jedisTemplete")
	public JedisTemplete jedisTemplete(MyRedisProperties myRedisProperties) {
		JedisTemplete jedisTemplete = new JedisTemplete();
		
		jedisTemplete.setJedisPool(myRedisProperties.getJedisPool());
		
		return jedisTemplete;
	}
}
