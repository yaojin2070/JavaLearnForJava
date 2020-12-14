package com.yjdzm.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author YaoJin
 * @create 2020-12-14 21:27
 * @description
 */
public class DruidTest {
  @Test
  public void getConnection() throws Exception{
    Properties pros = new Properties();

    InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

    pros.load(is);

    DataSource source = DruidDataSourceFactory.createDataSource(pros);
    Connection conn = source.getConnection();
    System.out.println(conn);

  }
}
