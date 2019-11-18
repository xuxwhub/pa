package com.dunshan.biz.service;

import com.dunshan.biz.client.PbClient;
import com.dunshan.biz.model.User;
import com.dunshan.common.ErpConstants;
import com.dunshan.common.exception.BusinessErrorException;
import com.dunshan.common.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuxinwei
 * @create 2019-11-18
 */
@Service
public class PABCDRedisMqService {

  private static final Logger logger = LoggerFactory.getLogger(PARedisMqService.class);

  @Autowired
  private PARedisService paRedisService;

  @Autowired
  private PbClient pbClient;

  @Autowired
  private PrMqService mqService;


  public User getById(String id) {
    User result = paRedisService.getById(id);
    ResultVO<User> pbUser = pbClient.get4bcd(id);
    logger.info("pbClient get4bcd result: " + pbUser);

    return result;
  }

  @Transactional
  public Boolean add(User user) {
    Boolean result = paRedisService.add(user);
    ResultVO<Boolean> pbResult = pbClient.add4bcd(user);
    logger.info("pbClient add4bcd result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient add error !");
    }
    mqService.sendMessage("add", user);
    return result;
  }

  @Transactional
  public Boolean update(User user) {
    Boolean result = paRedisService.update(user);
    ResultVO<Boolean> pbResult = pbClient.update4bcd(user);
    logger.info("pbClient update4bcd result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient update error !");
    }
    mqService.sendMessage("update", user);
    return result;
  }

  @Transactional
  public Boolean deleteById(String id) {
    Boolean result = paRedisService.deleteById(id);
    ResultVO<Boolean> pbResult = pbClient.delete4bcd(id);
    logger.info("pbClient delete4bcd result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient delete error !");
    }

    User param = new User();
    param.setId(id);
    mqService.sendMessage("delete", param);

    return result;
  }


}
