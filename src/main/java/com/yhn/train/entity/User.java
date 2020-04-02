package com.yhn.train.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String id;
  private String userName;
  private Integer age;
  private Date birthDay;
  private String address;
  private String phone;
  private Date createTime;
  private Date updateTime;
}
