package com.yjdzm.dao;

import com.yjdzm.orm.Customer;
import com.yjdzm.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * @author YaoJin
 * @create 2020-12-14 19:00
 * @description
 */
public class CustomerTest {
  private CustomerDaoClass dao = new CustomerDaoClass();
  @Test
  public void testInsert() {
    Connection conn = null;
    try {
      conn = JDBCUtils.getConnection();
      Customer cust = new Customer(1, "于小飞", "xiaofei@126.com",new Date(43534646435L));
      dao.insert(conn, cust);
      System.out.println("添加成功");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, null);
    }
  }
}
