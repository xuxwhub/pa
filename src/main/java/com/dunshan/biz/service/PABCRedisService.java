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
public class PABCRedisService {

  private static final Logger logger = LoggerFactory.getLogger(PARedisMqService.class);

  @Autowired
  private PARedisService paRedisService;

  @Autowired
  private PbClient pbClient;


  public User getById(String id) {
    User result = paRedisService.getById(id);
    ResultVO<User> pbUser = pbClient.get4bc(id);
    logger.info("pbClient get4bc result: " + pbUser);
    return result;
  }

  @Transactional
  public Boolean add(User user) {
    Boolean result = paRedisService.add(user);
    ResultVO<Boolean> pbResult = pbClient.add4bc(user);
    logger.info("pbClient add4bc result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient add error !");
    }
    return result;
  }

  @Transactional
  public Boolean update(User user) {
    Boolean result = paRedisService.update(user);
    ResultVO<Boolean> pbResult = pbClient.update4bc(user);
    logger.info("pbClient update4bc result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient update error !");
    }
    return result;
  }

  @Transactional
  public Boolean deleteById(String id) {
    Boolean result = paRedisService.deleteById(id);
    ResultVO<Boolean> pbResult = pbClient.delete4bc(id);
    logger.info("pbClient delete4bc result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient delete error !");
    }
    return result;
  }


}
