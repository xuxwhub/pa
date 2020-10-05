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
@FeignClient(name = "PB-SERVICE", fallback = PbClientFallback.class)
@Component
public interface PbClient {

  @PostMapping("/pb/add")
  ResultVO<Boolean> add4b(@RequestBody User user);

  @PostMapping("/pb/update")
  ResultVO<Boolean> update4b(@RequestBody User user);

  @PostMapping("/pb/delete/{id}")
  ResultVO<Boolean> delete4b(@PathVariable("id") String id);

  @GetMapping("/pb/query/{id}")
  ResultVO<User> get4b(@PathVariable("id") String id);


  @PostMapping("/pbc/add")
  ResultVO<Boolean> add4bc(@RequestBody User user);

  @PostMapping("/pbc/update")
  ResultVO<Boolean> update4bc(@RequestBody User user);

  @PostMapping("/pbc/delete/{id}")
  ResultVO<Boolean> delete4bc(@PathVariable("id") String id);

  @GetMapping("/pbc/query/{id}")
  ResultVO<User> get4bc(@PathVariable("id") String id);


  @PostMapping("/pbcd/add")
  ResultVO<Boolean> add4bcd(@RequestBody User user);

  @PostMapping("/pbcd/update")
  ResultVO<Boolean> update4bcd(@RequestBody User user);

  @PostMapping("/pbcd/delete/{id}")
  ResultVO<Boolean> delete4bcd(@PathVariable("id") String id);

  @GetMapping("/pbcd/query/{id}")
  ResultVO<User> get4bcd(@PathVariable("id") String id);

}
