package com.dunshan.biz.controller;

import com.dunshan.biz.model.User;
import com.dunshan.biz.service.PAService;
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
 * @create 2019-10-31
 */
@RestController
@RequestMapping(value = "pa")
public class PAController {

  @Autowired
  private PAService paService;

  @PostMapping("/add")
  public ResultVO<Boolean> add(@RequestBody User user) {
    Boolean result = paService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/update")
  public ResultVO<Boolean> update(@RequestBody User user) {
    Boolean result = paService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/delete/{id}")
  public ResultVO<Boolean> deleteById(@PathVariable("id") String id) {
    Boolean result = paService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @GetMapping("/query/{id}")
  public ResultVO<User> getById(@PathVariable("id") String id) {
    User user = paService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }
}
