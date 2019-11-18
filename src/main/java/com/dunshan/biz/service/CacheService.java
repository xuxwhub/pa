package com.dunshan.biz.service;

import com.alibaba.fastjson.JSON;
import com.dunshan.biz.model.User;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author xuxinwei
 * @create 2019-10-18
 */
@Service
public class CacheService {

  public static final String REDIS_STRING_KEY = "PA:STRING";

  public static final String REDIS_USER_KEY = "PA:HASH:USER";


  public static final long TIMEOUT_MINUTE = 10;

  public static final long TIMEOUT_HOUR_USER = 24;


  @Autowired
  private RedisTemplate redisTemplate;


  public void saveUser(User user) {
    redisTemplate.opsForHash().put(REDIS_USER_KEY, user.getId(), JSON.toJSONString(user));
    redisTemplate.expire(REDIS_USER_KEY, TIMEOUT_HOUR_USER, TimeUnit.HOURS);
  }

  public void deleteUser(String id) {
    redisTemplate.opsForHash().delete(REDIS_USER_KEY, id);
  }

  public User getUser(String id) {
    Object cacheUser = redisTemplate.opsForHash().get(REDIS_USER_KEY, id);
    if (Objects.isNull(cacheUser) || StringUtils.isEmpty(cacheUser.toString())) {
      return null;
    }
    return (User)JSON.parseObject(cacheUser.toString(), User.class);
  }

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
