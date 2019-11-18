package com.dunshan.biz.controller;

import com.dunshan.biz.client.PbClient;
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


}
