package com.yjdzm.dao;

import com.yjdzm.orm.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @author YaoJin
 * @create 2020-12-14 18:38
 * @description
 */
public class CustomerDaoClass extends BaseDao<Customer> implements CustomerDao{
  @Override
  public void insert(Connection conn, Customer cust) {
    String sql = "insert into customers(name,email,birth)values(?,?,?)";
    update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth());
  }

  @Override
  public void deleteById(Connection conn, int id) {

  }

  @Override
  public void update(Connection conn, Customer cust) {

  }

  @Override
  public Customer getCustomerById(Connection conn, int id) {
    return null;
  }

  @Override
  public List<Customer> getAll(Connection conn) {
    return null;
  }

  @Override
  public Long getCount(Connection conn) {
    return null;
  }

  @Override
  public Date getMaxBirth(Connection conn) {
    return null;
  }
}

