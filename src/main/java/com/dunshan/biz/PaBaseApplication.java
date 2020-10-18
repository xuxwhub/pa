package com.dunshan.biz;

import com.dunshan.biz.client.PbClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(scanBasePackages = {"com.dunshan"})
@MapperScan(basePackages = {"com.dunshan.biz.mapper"})
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = {PbClient.class})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class PaBaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaBaseApplication.class, args);
  }

}
