package com.yjdzm.blob;

import com.yjdzm.orm.Customer;
import com.yjdzm.utils.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @author YaoJin
 * @create 2020-12-13 17:53
 * @description
 */
public class blobTest {
  @Test
  public void testInstance() throws Exception{
    Connection conn = JDBCUtils.getConnection();
    String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

    PreparedStatement ps = conn.prepareStatement(sql);

    ps.setObject(1,"袁浩");
    ps.setObject(2, "yuan@qq.com");
    ps.setObject(3,"1992-09-08");

    FileInputStream f = new FileInputStream(new File("src/main/girl.jpg"));
    ps.setBlob(4, f);
    ps.execute();
    JDBCUtils.closeResource(conn, ps);
  }

  // 查询表中的blob, 复制
  @Test
  public void testQuery() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    InputStream is = null;
    FileOutputStream fos = null;
    try {
      conn = JDBCUtils.getConnection();
      String sql = "select id,name,email,birth,photo from customers where id = ?";
      ps = conn.prepareStatement(sql);
      ps.setObject(1, 19);
      rs = ps.executeQuery();
      if (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        Date birth = rs.getDate("birth");

        Customer cust = new Customer(id, name, email, birth);

        System.out.println(cust);

      // 获取图片
        Blob photo = rs.getBlob("photo");
        is = photo.getBinaryStream();
        fos = new FileOutputStream("zhangyuhao.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
          fos.write(buffer, 0, len);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (is != null) {
          is.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(fos != null)
          fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      JDBCUtils.closeResource(conn, ps, rs);
    }
  }
}


