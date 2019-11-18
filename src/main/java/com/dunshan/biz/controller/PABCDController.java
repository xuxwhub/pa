package com.dunshan.biz.controller;

import com.dunshan.biz.model.User;
import com.dunshan.biz.service.PABCDRedisMqService;
import com.dunshan.biz.service.PABCDRedisService;
import com.dunshan.biz.service.PABCDService;
import com.dunshan.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinwei
 * @create 2019-11-06
 */
@RestController
@RequestMapping(value = "pabcd")
public class PABCDController {

  @Autowired
  private PABCDService pabcdService;

  @Autowired
  private PABCDRedisService pabcdRedisService;

  @Autowired
  private PABCDRedisMqService pabcdRedisMqService;

  @PostMapping("/add")
  public ResultVO<Boolean> add(@RequestBody User user) {
    Boolean result = pabcdService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/update")
  public ResultVO<Boolean> update(@RequestBody User user) {
    Boolean result = pabcdService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/delete/{id}")
  public ResultVO<Boolean> deleteById(@PathVariable("id") String id) {
    Boolean result = pabcdService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/query/{id}")
  public ResultVO<User> getById(@PathVariable("id") String id) {
    User user = pabcdService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }


  @PostMapping("/redis/add")
  public ResultVO<Boolean> addRedis(@RequestBody User user) {
    Boolean result = pabcdRedisService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis/update")
  public ResultVO<Boolean> updateRedis(@RequestBody User user) {
    Boolean result = pabcdRedisService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis/delete/{id}")
  public ResultVO<Boolean> deleteRedisById(@PathVariable("id") String id) {
    Boolean result = pabcdRedisService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/redis/query/{id}")
  public ResultVO<User> getRedisById(@PathVariable("id") String id) {
    User user = pabcdRedisService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }


  @PostMapping("/redis_mq/add")
  public ResultVO<Boolean> addRedisMq(@RequestBody User user) {
    Boolean result = pabcdRedisMqService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis_mq/update")
  public ResultVO<Boolean> updateRedisMq(@RequestBody User user) {
    Boolean result = pabcdRedisMqService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis_mq/delete/{id}")
  public ResultVO<Boolean> deleteRedisMqById(@PathVariable("id") String id) {
    Boolean result = pabcdRedisMqService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/redis_mq/query/{id}")
  public ResultVO<User> getRedisMqById(@PathVariable("id") String id) {
    User user = pabcdRedisMqService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }
}
