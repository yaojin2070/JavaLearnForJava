package com.yjdzm.dao;

import com.yjdzm.orm.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @author YaoJin
 * @create 2020-12-14 8:24
 * @description
 */
public interface CustomerDao {
  void insert(Connection conn, Customer cust);
  void deleteById(Connection conn, int id);
  void update(Connection conn,Customer cust);
  Customer getCustomerById(Connection conn,int id);
  List<Customer> getAll(Connection conn);
  Long getCount(Connection conn);
  Date getMaxBirth(Connection conn);
}
