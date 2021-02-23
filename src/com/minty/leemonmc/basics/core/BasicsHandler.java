package com.minty.leemonmc.basics.core;

import redis.clients.jedis.Jedis;

public class BasicsHandler
{

	private final static Jedis jedis = new Jedis("127.0.0.1", 6379);
	
	public static void setup() {
		loadRedis(null);
	}
	
	private static void loadRedis(String MDP) {
		if (MDP != null && !MDP.isEmpty()) {
			if (jedis.isConnected())
				jedis.auth(MDP);
			else {
				jedis.connect();
				
				jedis.auth(MDP);
			}
		}else {
			if (!jedis.isConnected()) 
				jedis.connect();
			else jedis.disconnect();
		}
	}
	
	public static Jedis getJedis() {
		return jedis;
	}
	
}
