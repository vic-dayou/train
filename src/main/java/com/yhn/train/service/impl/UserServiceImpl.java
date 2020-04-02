package com.yhn.train.service.impl;

import com.yhn.train.dao.UserDao;
import com.yhn.train.dto.QueryDto;
import com.yhn.train.entity.User;
import com.yhn.train.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;


  @Override
  public User findOne(String id) {
    return userDao.findOne(id);
  }

  @Override
  public List<User> findAll(QueryDto queryDto) {
    return userDao.findAllUser(queryDto);
  }

  @Override
  public void updateUser(User user) {
    userDao.updateUser(user);
  }

  @Override
  public void deleteUser(String id) {
    userDao.deleteUser(id);
  }

  @Override
  public void addUser(User user) {
    userDao.addUser(user);
  }

  @Override
  public int validatePhone(String phone) {
    return userDao.validatePhone(phone);
  }
}
