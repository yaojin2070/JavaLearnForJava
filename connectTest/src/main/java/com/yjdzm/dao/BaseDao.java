package com.yjdzm.dao;

import com.yjdzm.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;

/**
 * @author YaoJin
 * @create 2020-12-14 8:27
 * @description
 */
public abstract class BaseDao<T> {
  private Class<T> clazz = null;
  {
    Type genericSuperclass = this.getClass().getGenericSuperclass();
    System.out.println(genericSuperclass);
    ParameterizedType paramType = (ParameterizedType) genericSuperclass;

    Type[] typeArguments = paramType.getActualTypeArguments();//获取了父类的泛型参数
    clazz = (Class<T>) typeArguments[0];//泛型的第一个参数
  }
  public int update(Connection conn, String sql, Object ...args) {
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      for (int i = 0; i < args.length; i++) {
        ps.setObject(i + 1, args[i]);
      }
      // 3.执行
      return ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(null, ps);
    }
    return 0;
  }

  public<T> T getInstance(Connection conn, Class<T> clazz, String sql, Object ...args) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      ps = conn.prepareStatement(sql);
      for (int i = 0; i < args.length; i++) {
        ps.setObject(i + 1, args[i]);
      }
      rs = ps.executeQuery();
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();
      if (rs.next()) {
        T t = clazz.newInstance();
        for (int i = 0; i < columnCount; i++) {
          Object columnValue = rs.getObject(i + 1);

          String columnLabel = rsmd.getColumnLabel(i + 1);

          Field field = clazz.getDeclaredField(columnLabel);

          field.setAccessible(true);
          field.set(t, columnValue);
        }
        return t;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(null, ps, rs);
    }
    return null;
  }
}
