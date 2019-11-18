package com.dunshan.biz.controller;

import com.dunshan.biz.model.User;
import com.dunshan.biz.service.PABRedisService;
import com.dunshan.biz.service.PABService;
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
@RequestMapping(value = "pab")
public class PABController {

  @Autowired
  private PABService pabService;

  @Autowired
  private PABRedisService pabRedisService;

  @PostMapping("/add")
  public ResultVO<Boolean> add(@RequestBody User user) {
    Boolean result = pabService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/update")
  public ResultVO<Boolean> update(@RequestBody User user) {
    Boolean result = pabService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/delete/{id}")
  public ResultVO<Boolean> deleteById(@PathVariable("id") String id) {
    Boolean result = pabService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/query/{id}")
  public ResultVO<User> getById(@PathVariable("id") String id) {
    User user = pabService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }

  @PostMapping("/redis/add")
  public ResultVO<Boolean> addRedis(@RequestBody User user) {
    Boolean result = pabRedisService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis/update")
  public ResultVO<Boolean> updateRedis(@RequestBody User user) {
    Boolean result = pabRedisService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/redis/delete/{id}")
  public ResultVO<Boolean> deleteRedisById(@PathVariable("id") String id) {
    Boolean result = pabRedisService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/redis/query/{id}")
  public ResultVO<User> getRedisById(@PathVariable("id") String id) {
    User user = pabRedisService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }
}
