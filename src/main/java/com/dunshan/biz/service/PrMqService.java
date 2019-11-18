package com.dunshan.biz.service;

import com.alibaba.fastjson.JSON;
import com.dunshan.biz.model.User;
import com.dunshan.biz.model.UserMqMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author xuxinwei
 * @create 2019-10-21
 */
@Service
public class PrMqService {

  private static final Logger logger = LoggerFactory.getLogger(PrMqService.class);

  /**
   * exchange-common
   */
  public static final String EXCHANGE_COMMON = "e.common.direct";

  /**
   * Routing-Key
   */
  public static final String ROUTING_KEY_LOG = "k.direct.pr.log";

  @Autowired
  private AmqpTemplate rabbitTemplate;

  /**
   * 发送消息给pr
   * @param message
   */
  public void sendLog2Pr(String message) {
    logger.info("发送消息【{}】【{}】：{}", EXCHANGE_COMMON, ROUTING_KEY_LOG, message);
    rabbitTemplate.convertAndSend(EXCHANGE_COMMON, ROUTING_KEY_LOG, message);
  }

  public void sendMessage(String operation, User user) {
    UserMqMessage message = new UserMqMessage();
    message.setOperation(operation);
    message.setData(user);
    this.sendLog2Pr(JSON.toJSONString(message));
  }

}
