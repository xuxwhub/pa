package com.dunshan.biz;

import com.dunshan.biz.service.PbClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"com.dunshan.biz"})
@MapperScan(basePackages = {"com.dunshan.biz.mapper"})
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = {PbClient.class})
public class BaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BaseApplication.class, args);
  }

}
