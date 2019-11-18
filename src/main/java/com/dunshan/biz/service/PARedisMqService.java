package com.dunshan.biz.service;

import com.alibaba.fastjson.JSON;
import com.dunshan.biz.model.User;
import com.dunshan.biz.model.UserMqMessage;
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
public class PARedisMqService {

  private static final Logger logger = LoggerFactory.getLogger(PARedisMqService.class);

  @Autowired
  private UserService userService;

  @Autowired
  private CacheService cacheService;

  @Autowired
  private PrMqService mqService;


  public User getById(String id) {
    User cache = cacheService.getUser(id);
    logger.info("cache user: {}", cache);
    return userService.getById(id);
  }

  @Transactional
  public Boolean add(User user) {
    Boolean result = userService.add(user);
    cacheService.saveUser(user);
    mqService.sendMessage("add", user);
    return result;
  }

  @Transactional
  public Boolean deleteById(String id) {
    Boolean result = userService.deleteById(id);
    cacheService.deleteUser(id);
    User param = new User();
    param.setId(id);
    mqService.sendMessage("delete", param);
    return result;
  }

  @Transactional
  public Boolean update(User user) {
    Boolean result = userService.update(user);
    cacheService.saveUser(user);
    mqService.sendMessage("update", user);
    return result;
  }


}
