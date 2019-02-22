package com.auto.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTemplete {
	private JedisPool jedisPool;
		
	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

    public Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close(final Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
    
    public String getValue(String key) {
    	return getJedis().get(key);
    }
}
