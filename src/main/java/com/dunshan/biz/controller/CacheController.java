package com.dunshan.biz.controller;

import com.dunshan.biz.service.CacheService;
import com.dunshan.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinwei
 * @create 2019-10-18
 */
@RestController
@RequestMapping(value = "cache")
public class CacheController {

  @Autowired
  private CacheService cacheService;

  @GetMapping("/string/refresh")
  @ResponseBody
  public ResultVO<Boolean> refreshString() {
    cacheService.refreshString();
    return ResultVO.<Boolean>builder().success(Boolean.TRUE).build();

  }

  @GetMapping("/string/view")
  @ResponseBody
  public ResultVO<String> getString() {
    String result = cacheService.getString();
    return ResultVO.<String>builder().success(result).build();
  }
}
