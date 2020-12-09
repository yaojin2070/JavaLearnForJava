package com.yjdzm.connect;

import org.junit.Test;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author YaoJin
 * @create 2020-12-09 16:39
 * @description
 */
public class connectTest {
  @Test
  public void testConnectTest() throws SQLException {
    Driver driver = new com.mysql.jdbc.Driver();

    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
    Properties info = new Properties();
    info.setProperty("user", "root");
    info.setProperty("password", "123456");
    Connection conn = driver.connect(url, info);
    System.out.println(conn);
  }
}
