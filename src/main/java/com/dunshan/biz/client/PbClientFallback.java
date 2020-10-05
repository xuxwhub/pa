package com.dunshan.biz.client;

import com.dunshan.biz.model.User;
import com.dunshan.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xuxinwei
 * @create 2019-10-20
 */
@Component
public class PbClientFallback implements PbClient{


  @Override
  public ResultVO<Boolean> add4b(User user) {
    return ResultVO.error("add4b fall back");
  }

  @Override
  public ResultVO<Boolean> update4b(User user) {
    return ResultVO.error("update4b fall back");
  }

  @Override
  public ResultVO<Boolean> delete4b(String id) {
    return ResultVO.error("delete4b fall back");
  }

  @Override
  public ResultVO<User> get4b(String id) {
    return ResultVO.error("get4b fall back");
  }

  @Override
  public ResultVO<Boolean> add4bc(User user) {
    return ResultVO.error("add4bc fall back");
  }

  @Override
  public ResultVO<Boolean> update4bc(User user) {
    return ResultVO.error("update4bc fall back");
  }

  @Override
  public ResultVO<Boolean> delete4bc(String id) {
    return ResultVO.error("delete4bc fall back");
  }

  @Override
  public ResultVO<User> get4bc(String id) {
    return ResultVO.error("get4bc fall back");
  }

  @Override
  public ResultVO<Boolean> add4bcd(User user) {
    return ResultVO.error("add4bcd fall back");
  }

  @Override
  public ResultVO<Boolean> update4bcd(User user) {
    return ResultVO.error("update4bcd fall back");
  }

  @Override
  public ResultVO<Boolean> delete4bcd(String id) {
    return ResultVO.error("delete4bcd fall back");
  }

  @Override
  public ResultVO<User> get4bcd(String id) {
    return ResultVO.error("get4bcd fall back");
  }
}
