package com.dunshan.biz.controller;

import com.dunshan.biz.service.PrMqService;
import com.dunshan.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinwei
 * @create 2019-10-21
 */
@RestController
@RequestMapping(value = "mq")
public class MqController {

  @Autowired
  private PrMqService prMqService;

  @PostMapping("/pr/log")
  public ResultVO<Boolean> sendLog2Pr(@RequestParam String message) {
    prMqService.sendLog2Pr(message);
    return ResultVO.<Boolean>builder().success(Boolean.TRUE).build();
  }

}
