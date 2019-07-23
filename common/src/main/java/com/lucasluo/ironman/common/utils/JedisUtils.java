package com.lucasluo.ironman.common.utils;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class JedisUtils {

    @Resource
    private RedisTemplate<String, Object> jedisTemplate;

    public Object get(String key) {
        return key == null ? null : jedisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object value) {
        boolean result = true;
        try {
            jedisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {

            return false;
        }
        return result;
    }

    public boolean set(String key, Object value, long time) {
        boolean result = true;
        try {
            if(time > 0) {
                jedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
