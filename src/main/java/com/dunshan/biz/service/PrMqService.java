package com.dunshan.biz.service;

import static com.dunshan.biz.util.CommonControllerInterceptor.TEST_FLAG;

import com.alibaba.fastjson.JSON;
import com.dunshan.biz.model.User;
import com.dunshan.biz.model.UserMqMessage;
import com.dunshan.biz.util.TestFlagHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.support.postprocessor.MessagePostProcessorUtils;
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

    MessagePostProcessor messagePostProcessor = message1 -> {
      message1.getMessageProperties().setHeader(TEST_FLAG, TestFlagHolder.get() == null ? "" : TestFlagHolder.get());
      return message1;
    };

    rabbitTemplate.convertAndSend(EXCHANGE_COMMON, ROUTING_KEY_LOG, message, messagePostProcessor);
  }

  public void sendMessage(String operation, User user) {
    UserMqMessage message = new UserMqMessage();
    message.setOperation(operation);
    message.setData(user);
    this.sendLog2Pr(JSON.toJSONString(message));
  }

}
