package com.yjdzm.test;

import com.yjdzm.bean.Book;
import com.yjdzm.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author YaoJin
 * @create 2021-01-01 9:59
 * @description
 */
public class TestMybatis {
  @Test
  public void test() throws IOException {
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 创建接口对象
    BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
    Book book = bookMapper.getBookById("1");
    System.out.println(book);
  }
}
