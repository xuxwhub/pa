package com.dunshan.biz.service;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author xuxinwei
 * @create 2019-10-18
 */
@Service
public class CacheService {

  public static final String REDIS_STRING_KEY = "PA:STRING";

  public static final long TIMEOUT_MINUTE = 10;

  @Autowired
  private RedisTemplate redisTemplate;


  public void refreshString() {
    String currentTime = new Date().toString();
    redisTemplate.opsForValue().set(REDIS_STRING_KEY, currentTime);
    redisTemplate.expire(REDIS_STRING_KEY, TIMEOUT_MINUTE, TimeUnit.MINUTES);
  }

  public String getString() {
    Object value =  redisTemplate.opsForValue().get(REDIS_STRING_KEY);
    return Objects.isNull(value) ? "" : value.toString();
  }
}
