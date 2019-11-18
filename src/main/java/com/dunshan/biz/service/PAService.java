package com.dunshan.biz.service;

import com.dunshan.biz.mapper.UserMapper;
import com.dunshan.biz.model.User;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author xuxinwei
 * @create 2019-10-31
 */
@Service
public class PAService {

  @Resource
  private UserMapper mapper;

  public List<User> listAll() {
    return mapper.selectAll();
  }

  public User getById(String id) {
    return mapper.selectByPrimaryKey(id);
  }

  public Boolean add(User user) {
    return mapper.insertSelective(user) > 0;
  }

  public Boolean deleteById(String id) {
    return mapper.deleteByPrimaryKey(id) > 0;
  }

  public Boolean update(User user) {
    if (StringUtils.isEmpty(user.getId())) {
      throw new RuntimeException("id can not be null！");
    }
    return mapper.updateByPrimaryKeySelective(user) > 0;
  }


}
