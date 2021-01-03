package com.yjdzm.bean;

import java.util.List;

/**
 * @author YaoJin
 * @create 2021-01-01 9:28
 * @description
 */
public class Book {
  private Integer id;
  private String name;
  private Integer money;
  private List<User> users;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMoney() {
    return money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", money=" + money +
            ", users=" + users +
            '}';
  }
}
