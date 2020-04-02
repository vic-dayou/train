package com.yhn.train.dao;

import com.yhn.train.dto.QueryDto;
import com.yhn.train.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

  void addUser(User user);
  void batchAddUser(@Param("users") List<User> users);
  User findOne(String id);
  List<User> findAllUser(QueryDto queryDto);
  void updateUser(User user);
  void deleteUser(String id);
  int validatePhone(String phone);

}
