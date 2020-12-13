package com.yjdzm.connect;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author YaoJin
 * @create 2020-12-09 16:39
 * @description
 */
public class connectTest {
  // 方法一
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

  // 方法二(通过发射的作用获取实例, 不需要通过第三方包引入)
  @Test
  public void testConnectTest2() throws Exception {
    // 获取运行实例
    Class clazz = Class.forName("com.mysql.jdbc.Driver");
    Driver driver = (Driver) clazz.newInstance();
    // 2.提供需要连接的mysql地址
    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
    // 3.提供连接需要的用户名和密码
    Properties info = new Properties();
    info.setProperty("user", "root");
    info.setProperty("password", "123456");

    // 4.获取连接
    Connection conn = driver.connect(url, info);
    System.out.println(conn);
  }

  // 方式三 使用DriverManager替换Driver
  @Test
  public void testConnection3() throws Exception {
    // 1.获取Driver实现类的对象
    Class clazz = Class.forName("com.mysql.jdbc.Driver");
    Driver driver = (Driver) clazz.newInstance();

    // 2.提供另外三个连接的基本信息：
    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
    String user = "root";
    String password = "123456";

    // 注册驱动
    DriverManager.registerDriver(driver);

    // 获取连接
    Connection conn = DriverManager.getConnection(url, user, password);
    System.out.println(conn);
  }

  // 方式四, 只加载驱动, 不注册
  @Test
  public void testConnection4() throws Exception {
    // 在Driver 中其实内部已经实现了注册
    Class.forName("com.mysql.jdbc.Driver");

    // 2.提供另外三个连接的基本信息：
    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
    String user = "root";
    String password = "123456";


    // 获取连接
    Connection conn = DriverManager.getConnection(url, user, password);
    System.out.println(conn);
  }

  // 方式五, 通过配置文件进行连接
  @Test
  public void testConnection5() throws Exception {
    System.out.println(connectTest.class.getClassLoader());
    System.out.println(13313131);
    System.out.println(ClassLoader.getSystemClassLoader());
    // 读取配置文件
    InputStream is = connectTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
    Properties pros = new Properties();
    pros.load(is);
    String user = pros.getProperty("user");
    String password = pros.getProperty("password");
    String url = pros.getProperty("url");
    String driverClass = pros.getProperty("driverClass");

    //2.加载驱动
    Class.forName(driverClass);

    //3.获取连接
    Connection conn = DriverManager.getConnection(url, user, password);
    System.out.println(conn);
  }

}

