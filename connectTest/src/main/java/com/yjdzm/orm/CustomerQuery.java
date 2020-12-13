package com.yjdzm.orm;

import com.yjdzm.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author YaoJin
 * @create 2020-12-13 10:01
 * @description
 */
public class CustomerQuery {
  @Test
  public void testQuery() {
    String sql = "select id,name,birth,email from customers where id = ?";

    Customer customer = queryForCustomer(sql, 13);

    System.out.println(customer);
  }

  @Test
  public void testQuery1() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JDBCUtils.getConnection();
      String sql = "select id,name,email,birth from customers where id = ?";
      ps = conn.prepareStatement(sql);
      ps.setObject(1, 1);
      rs = ps.executeQuery();
      //执行,并返回结果集
      rs = ps.executeQuery();


      if (rs.next()) {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String email = rs.getString(3);
        Date birth = rs.getDate(4);
        System.out.println( name);
        Customer customer = new Customer(id, name, email, birth);
        System.out.println(customer);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps, rs);
    }

  }


  public Customer queryForCustomer(String sql, Object ...args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      // 连接mysql
      conn = JDBCUtils.getConnection();
      // 创建PreparedStatement对象, 用于将sql语句传送到数据库中
      ps = conn.prepareStatement(sql);

      // 给sql的? 标记 填充
      for (int i = 0; i < args.length; i++) {
        ps.setObject(i + 1, args[i]);
      }

      // 将查询的数据生成ResultSet对象
      rs = ps.executeQuery();

      // 获取结果集的元数据
      ResultSetMetaData rsmd = rs.getMetaData();

      //通过ResultSetMetaData获取结果集中的列数
      int columnCount = rsmd.getColumnCount();

      if (rs.next()) {
        Customer cust = new Customer();
        // 获取结果集中的数据
        for (int i = 0; i < columnCount; i++) {
          // 获取对应列的值
          Object columnValue = rs.getObject(i + 1);
          // 获取列名
          String columnLabel = rsmd.getColumnLabel(i + 1);

          //给cust对象指定的columnName属性，赋值为columValue：通过反射
          Field field = Customer.class.getDeclaredField(columnLabel);
          field.setAccessible(true);
          field.set(cust, columnValue);
        }
        return cust;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps, rs);
    }
    return null;
  }
}