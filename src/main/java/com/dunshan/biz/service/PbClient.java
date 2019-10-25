package com.dunshan.biz.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuxinwei
 * @create 2019-10-20
 */
@FeignClient(name = "PB-SERVICE")
@Component
public interface PbClient {


  @GetMapping("/interface/hello")
  String hello();

  @GetMapping("/interface/hello/pc")
  String hello2pc();

}
