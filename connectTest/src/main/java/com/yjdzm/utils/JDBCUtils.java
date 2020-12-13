package com.yjdzm.utils;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author YaoJin
 * @create 2020-12-11 19:55
 * @description: 操作数据库的工具类
 */

// 创建连接
public class JDBCUtils {
  @Test
  public static Connection getConnection () throws Exception {
    InputStream is = ClassLoader.getSystemClassLoader().getSystemResourceAsStream("jdbc.properties");
    Properties pros = new Properties();
    pros.load(is);

    String user = pros.getProperty("user");
    String password = pros.getProperty("password");
    String url = pros.getProperty("url");
    String driverClass = pros.getProperty("driverClass");

    // 2.加载驱动
    Class.forName(driverClass);

    // 3.获取连接
    Connection conn = DriverManager.getConnection(url, user, password);
    return conn;
  }
  // 关闭资源
  public static void closeResource(Connection conn, Statement ps) {
    try {
      if(ps != null)
        ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if(conn != null)
        conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void closeResource(Connection conn, Statement ps, ResultSet rs){
    try {
      if(ps != null)
        ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if(conn != null)
        conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if(rs != null)
        rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}



