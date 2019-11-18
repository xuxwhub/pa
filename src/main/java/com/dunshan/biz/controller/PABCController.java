package com.dunshan.biz.controller;

import com.dunshan.biz.model.User;
import com.dunshan.biz.service.PABCRedisService;
import com.dunshan.biz.service.PABCService;
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
@RequestMapping(value = "pabc")
public class PABCController {

  @Autowired
  private PABCService pabcService;

  @Autowired
  private PABCRedisService pabcRedisService;

  @PostMapping("/add")
  public ResultVO<Boolean> add(@RequestBody User user) {
    Boolean result = pabcService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/update")
  public ResultVO<Boolean> update(@RequestBody User user) {
    Boolean result = pabcService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/delete/{id}")
  public ResultVO<Boolean> deleteById(@PathVariable("id") String id) {
    Boolean result = pabcService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/query/{id}")
  public ResultVO<User> getById(@PathVariable("id") String id) {
    User user = pabcService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }


  @PostMapping("/redis/add")
  public ResultVO<Boolean> addRedis(@RequestBody User user) {
    Boolean result = pabcRedisService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis/update")
  public ResultVO<Boolean> updateRedis(@RequestBody User user) {
    Boolean result = pabcRedisService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis/delete/{id}")
  public ResultVO<Boolean> deleteRedisById(@PathVariable("id") String id) {
    Boolean result = pabcRedisService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/redis/query/{id}")
  public ResultVO<User> getRedisById(@PathVariable("id") String id) {
    User user = pabcRedisService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }
}
