package com.yjdzm.bean;

/**
 * @author YaoJin
 * @create 2021-01-01 19:53
 * @description
 */
public class User {
  private Integer id;
  private String name;
  private String password;
  private String address;
  private String phone;
  private Book book;

  public String getPhone() {
    return phone;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public User(Integer id, String name, String password, String address, String phone) {
    super();
    this.id = id;
    this.name = name;
    this.password = password;
    this.address = address;
    this.phone = phone;
  }

  public User() {
//    super();
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoine() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", book=" + book +
            '}';
  }
}
