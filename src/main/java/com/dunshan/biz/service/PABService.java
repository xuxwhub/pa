package com.dunshan.biz.service;

import com.dunshan.biz.client.PbClient;
import com.dunshan.biz.model.User;
import com.dunshan.common.ErpConstants;
import com.dunshan.common.exception.BusinessErrorException;
import com.dunshan.common.vo.ResultVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.List;
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
public class PABService {

  private static final Logger logger = LoggerFactory.getLogger(PABService.class);

  @Autowired
  private PAService paService;

  @Autowired
  private PbClient pbClient;

  public List<User> listAll() {
    return paService.listAll();
  }

  public User getById(String id) {
    User result = paService.getById(id);
    ResultVO<User> pbResult = pbClient.get4b(id);
    logger.info("pbClient get result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient getById error !" + pbResult.getMsg());
    }
    return result;
  }

  @Transactional
//  @HystrixCommand(commandProperties = {
//      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),//指定多久超时，单位毫秒。超时进fallback
//      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
//      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),//判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
//  })
  public Boolean add(User user) {
    Boolean result = paService.add(user);
    ResultVO<Boolean> pbResult = pbClient.add4b(user);
    logger.info("pbClient add result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient add error !" + pbResult.getMsg());
    }
    return result;
  }

  @Transactional
  public Boolean update(User user) {
    Boolean result = paService.update(user);
    ResultVO<Boolean> pbResult = pbClient.update4b(user);
    logger.info("pbClient update result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient update error !" + pbResult.getMsg());
    }
    return result;
  }

  @Transactional
  public Boolean deleteById(String id) {
    Boolean result = paService.deleteById(id);
    ResultVO<Boolean> pbResult = pbClient.delete4b(id);
    logger.info("pbClient delete result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pbClient delete error !" + pbResult.getMsg());
    }
    return result;
  }


}
