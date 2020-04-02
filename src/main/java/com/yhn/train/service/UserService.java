package com.yhn.train.service;

import com.yhn.train.dto.QueryDto;
import com.yhn.train.entity.User;
import java.util.List;

public interface UserService {
  User findOne(String id);
  List<User> findAll(QueryDto queryDto);
  void updateUser(User user);
  void deleteUser(String id);
  void addUser(User user);
  int validatePhone(String phone);
}
