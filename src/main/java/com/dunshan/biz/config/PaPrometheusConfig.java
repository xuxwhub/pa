package com.dunshan.biz.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuxinwei
 * @create 2019-11-11
 */
@Configuration
public class PaPrometheusConfig {

  @Autowired
  private PrometheusMeterRegistry registry;

  @Bean
  public Counter testCounter() {

    Counter counter = Counter.builder("goods_rank_sync_count")
        .tags("status", "success")
        .description("Number of successful goods rank sync")
        .register(registry);
    return counter;
  }

}
