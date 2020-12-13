package com.yjdzm.connect1;

import com.yjdzm.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

  /**
 * @author YaoJin
 * @create 2020-12-11 17:41
 * @description
 */
public class PreparedStatementClass {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入你的用户名:");
      String user = scanner.nextLine();
      System.out.print("请输入密码:");
      String password = scanner.nextLine();
      String sql = "SELECT user,password FROM user_table WHERE user = ? and password = ?";
      User returnUser = getInstance(User.class,sql,user,password);
      if(returnUser != null){
        System.out.println("登录成功");
      }else{
        System.out.println("用户名不存在或密码错误");
      }
    }
  @Test
  public void LoginTest() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入你的用户名: ");
    String user = scanner.nextLine();
    System.out.print("请输入密码：");
    String password = scanner.nextLine();
    String sql = "SELECT user,password FROM user_table WHERE user = ? and password = ?";
    User returnUser = getInstance(User.class,sql,user,password);

    if(returnUser != null){
      System.out.println("登录成功");
    }else{
      System.out.println("用户名不存在或密码错误");
    }
  }

  //针对于不同的表的通用的查询操作，返回表中的一条记录
  public static <T> T getInstance(Class<T> clazz, String sql, Object... args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JDBCUtils.getConnection();

      ps = conn.prepareStatement(sql);
      for (int i = 0; i < args.length; i++) {
        ps.setObject(i + 1, args[i]);
      }

      rs = ps.executeQuery();
      // 获取结果集的元数据 :ResultSetMetaData
      ResultSetMetaData rsmd = rs.getMetaData();
      // 通过ResultSetMetaData获取结果集中的列数
      int columnCount = rsmd.getColumnCount();

      if (rs.next()) {
        T t = clazz.newInstance();
        // 处理结果集一行数据中的每一个列
        for (int i = 0; i < columnCount; i++) {
          // 获取列值
          Object columValue = rs.getObject(i + 1);

          // 获取每个列的列名
          // String columnName = rsmd.getColumnName(i + 1);
          String columnLabel = rsmd.getColumnLabel(i + 1);

          // 给t对象指定的columnName属性，赋值为columValue：通过反射
          Field field = clazz.getDeclaredField(columnLabel);
          field.setAccessible(true);
          field.set(t, columValue);
        }
        return t;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps, rs);
    }
    return null;
  }
}
