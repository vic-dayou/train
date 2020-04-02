package com.yhn.train.utils;

import java.util.UUID;

public class UUIDUtil {

  private UUIDUtil(){}

  public static String generate(){
    return UUID.randomUUID().toString().replaceAll("-","");
  }


  public static void main(String[] args) {
    System.out.println(UUIDUtil.generate());
  }
}
