package com.yjdzm.bean;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.stereotype.Component;

/**
 * @author YaoJin
 * @create 2020-12-30 18:32
 * @description
 */
public class User {
  private String name;

  public User() {

    System.out.println("创建了");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
