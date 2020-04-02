package com.yhn.train.dao;

import com.yhn.train.BaseTest;
import com.yhn.train.dto.QueryDto;
import com.yhn.train.entity.User;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {

  @Autowired
  private UserDao userDao;

  @Test
  public void addUserTest(){
    User user = new User();
    user.setId("23refasdfqw3jr2q3lkrqwnekjfowiej");
    user.setUserName("admin");
    user.setAge(12);
    user.setAddress("fengtaiqu ");
    user.setPhone("214213141");
    user.setBirthDay(new Date());
    userDao.addUser(user);
  }

  @Test
  public void BatchAddUserTest(){
    List<User> users = new LinkedList<>();
  /*  User user = new User("a","a",23,new Date(),"jk","12421341234");
    User user1 = new User("b","b",24,new Date(),"jkl","12421341234");
    User user2 = new User("c","c",25,new Date(),"jkm","12421341234");
    users.add(user);
    users.add(user1);
    users.add(user2);
    userDao.batchAddUser(users);*/
  }


  @Test
  public void findOneTest(){
    User user = userDao.findOne("a");
    Assert.assertEquals("a",user.getUserName());

  }

  @Test
  public void findAllUserTest(){
    QueryDto queryDto = new QueryDto();
    queryDto.setUserName("b");
    //queryDto.setAge(12);
    queryDto.setStartDate(new Date("2019/12/01"));
    queryDto.setEndDate(new Date("2019/12/21"));
    List<User> users = userDao.findAllUser(queryDto);
    Assert.assertEquals(1,users.size());
  }


  @Test
  public void updateUserTest() {
    User user = new User();
    user.setAge(89);
    user.setId("a");
    user.setUserName("aaaa");
    userDao.updateUser(user);
  }


  @Test
  public void deleteUserTest() {
    userDao.deleteUser("a");
  }

}
