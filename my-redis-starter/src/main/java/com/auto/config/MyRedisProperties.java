package com.auto.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@ConfigurationProperties(prefix = "my.redis")
public class MyRedisProperties {
    private String ADDR = "192.168.0.41";

    private int PORT = 6379;

    private String AUTH = "admin";
    
    private int MAX_TOTAL = 8;
    
    private int MIN_IDLE=0;
    
    private int MAX_IDLE = 8;
    
    private int MAX_WAIT = -1;
    
    private int TIMEOUT = 10000;

    private boolean BLOCK_WHEN_EXHAUSTED = false;

    private String EVICTION_POLICY_CLASSNAME="org.apache.commons.pool2.impl.DefaultEvictionPolicy";
    
    private boolean JMX_ENABLED=true;
   
    private String JMX_NAME_PREFIX="pool";

    private boolean LIFO=true;

    private long MIN_EVICTABLE_IDLE_TIME_MILLIS=1800000L;
    
    private long SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS=1800000L;

    private int NUM_TESTS_PER_EVICYION_RUN=3;

    private boolean TEST_ON_BORROW = false;

    private boolean TEST_WHILEIDLE=false;

    private long TIME_BERWEEN_EVICTION_RUNS_MILLIS=-1;
    
    public String getADDR() {
		return ADDR;
	}

	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}

	public int getPORT() {
		return PORT;
	}

	public void setPORT(int pORT) {
		PORT = pORT;
	}

	public String getAUTH() {
		return AUTH;
	}

	public void setAUTH(String aUTH) {
		AUTH = aUTH;
	}

    public JedisPool getJedisPool(){
    	JedisPoolConfig config = new JedisPoolConfig();
        config.setBlockWhenExhausted(BLOCK_WHEN_EXHAUSTED);
        config.setEvictionPolicyClassName(EVICTION_POLICY_CLASSNAME); 
        config.setJmxEnabled(JMX_ENABLED);
        config.setJmxNamePrefix(JMX_NAME_PREFIX);
        config.setLifo(LIFO);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxTotal(MAX_TOTAL);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setMinEvictableIdleTimeMillis(MIN_EVICTABLE_IDLE_TIME_MILLIS);
        config.setMinIdle(MIN_IDLE);
        config.setNumTestsPerEvictionRun(NUM_TESTS_PER_EVICYION_RUN);
        config.setSoftMinEvictableIdleTimeMillis(SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS);
        config.setTestOnBorrow(TEST_ON_BORROW);
        config.setTestWhileIdle(TEST_WHILEIDLE);
        config.setTimeBetweenEvictionRunsMillis(TIME_BERWEEN_EVICTION_RUNS_MILLIS);
        
        System.out.println("url:"+ADDR+" port:"+PORT+" pw:"+AUTH);
        
        JedisPool myJedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        
        return myJedisPool;
    }
}
