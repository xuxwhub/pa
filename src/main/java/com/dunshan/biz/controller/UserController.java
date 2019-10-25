package com.dunshan.biz.controller;

import com.dunshan.biz.model.User;
import com.dunshan.biz.service.UserService;
import com.dunshan.common.vo.ResultVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinwei
 * @create 2019-10-18
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public ResultVO<List<User>> listAll() {
    List<User> users = userService.listAll();
    return ResultVO.<List<User>>builder().success(users).build();
  }

  @GetMapping("/view/{id}")
  public ResultVO<User> getById(String id) {
    User user = userService.getById(id);
    return ResultVO.<User>builder().success(user).build();
  }

  @PostMapping("/mock")
  public ResultVO<Boolean> mock() {
    Boolean result = userService.addMock();
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/delete/{id}")
  public ResultVO<Boolean> mock(@PathVariable("id") String id) {
    Boolean result = userService.deleteById(id);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/add")
  public ResultVO<Boolean> add(@RequestBody User user) {
    Boolean result = userService.add(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

  @PostMapping("/update")
  public ResultVO<Boolean> update(@RequestBody User user) {
    Boolean result = userService.update(user);
    return ResultVO.<Boolean>builder().success(result).build();
  }

}
