package com.dunshan.biz.controller;

import com.dunshan.biz.service.PbClient;
import com.dunshan.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinwei
 * @create 2019-10-20
 */
@RestController
@RequestMapping(value = "/third")
public class ThirdController {

  @Autowired
  private PbClient pbClient;

  @GetMapping("/pb/hello")
  @ResponseBody
  public ResultVO<String> hello2pb() {
    String result = pbClient.hello();
    return ResultVO.<String>builder().success(result).build();
  }

  @GetMapping("/pb/hello/pc")
  @ResponseBody
  public ResultVO<String> ping() {
    String result = pbClient.hello2pc();
    return ResultVO.<String>builder().success(result).build();
  }
}
