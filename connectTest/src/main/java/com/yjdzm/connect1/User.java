package com.yjdzm.connect1;

/**
 * @author YaoJin
 * @create 2020-12-11 17:44
 * @description
 */
public class User {
  private String user;
  private String password;
  public User() {
  }

  public User(String user, String password) {
    super();
    this.user = user;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
            "user='" + user + '\'' +
            ", password=" + password +
            '}';
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
