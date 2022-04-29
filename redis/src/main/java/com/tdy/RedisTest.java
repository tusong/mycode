package com.tdy;

import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 1、JedisPoolConfig
 * 2、redisSentinelConfiguration
 *        设置哨兵节点、主节点名称
 * 3、JedisConnectionFactory
 * 4、StringRedisTemplate
 */
public class RedisTest {

    public static void main(String[] args) {


        JedisPoolConfig poolConfig = new JedisPoolConfig();

        RedisNode redisNode1 = new RedisNode("192.168.161.95", 26379);
        RedisNode redisNode2 = new RedisNode("192.168.161.95", 26380);
        RedisNode redisNode3 = new RedisNode("192.168.161.95", 26381);

//        RedisNode redisNode = new RedisNode();

        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        redisSentinelConfiguration.setMaster("mymaster");

        redisSentinelConfiguration.addSentinel(redisNode1);
        redisSentinelConfiguration.addSentinel(redisNode2);
        redisSentinelConfiguration.addSentinel(redisNode3);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisSentinelConfiguration,poolConfig);
        jedisConnectionFactory.setPassword("Tydk@202109");
        jedisConnectionFactory.afterPropertiesSet();

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        stringRedisTemplate.afterPropertiesSet();


//        stringRedisTemplate.opsForValue().set("aaaa","bbaaa");
        String aaaa = stringRedisTemplate.opsForValue().get("aaaa");

        System.out.println(aaaa);


    }

}
