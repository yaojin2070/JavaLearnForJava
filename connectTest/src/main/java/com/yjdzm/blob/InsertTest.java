package com.yjdzm.blob;

import com.yjdzm.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author YaoJin
 * @create 2020-12-13 19:36
 * @description
 */
public class InsertTest {

  public void testInsert2() {
    Connection conn = null;
    PreparedStatement ps = null;
    try {
      long start = System.currentTimeMillis();
      conn = JDBCUtils.getConnection();
      //设置不允许自动提交数据
      conn.setAutoCommit(false);
      String sql = "insert into goods(name)values(?)";
      ps = conn.prepareStatement(sql);
      for (int i = 0; i < 10000; i++) {
        ps.setObject(i, "name_" + i);
        //1."攒"sql
        ps.addBatch();
        if(i % 500 == 0){
          //2.执行batch
          ps.executeBatch();

          //3.清空batch
          ps.clearBatch();
        }
      }
      //提交数据
      conn.commit();
      long end = System.currentTimeMillis();
      System.out.println("花费的时间为：" + (end - start));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps);
    }
  }
}
