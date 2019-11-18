package com.dunshan.biz.service;

import com.dunshan.biz.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuxinwei
 * @create 2019-11-06
 */
@Service
public class PARedisService {

  private static final Logger logger = LoggerFactory.getLogger(PARedisService.class);

  @Autowired
  private UserService userService;

  @Autowired
  private CacheService cacheService;


  public User getById(String id) {
    User cache = cacheService.getUser(id);
    logger.info("cache user: {}", cache);
    return userService.getById(id);
  }

  @Transactional
  public Boolean add(User user) {
    Boolean result = userService.add(user);
    cacheService.saveUser(user);
    return result;
  }

  @Transactional
  public Boolean deleteById(String id) {
    Boolean result = userService.deleteById(id);
    cacheService.deleteUser(id);
    return result;
  }

  @Transactional
  public Boolean update(User user) {
    Boolean result = userService.update(user);
    cacheService.saveUser(user);
    return result;
  }

}
