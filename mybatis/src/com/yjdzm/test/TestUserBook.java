package com.yjdzm.test;

import com.yjdzm.bean.Book;
import com.yjdzm.bean.User;
import com.yjdzm.mapper.BookUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author YaoJin
 * @create 2021-01-03 15:54
 * @description
 */
public class TestUserBook {
  @Test
public  void testSelect() throws IOException {
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动处理事务
    BookUserMapper mapper = sqlSession.getMapper(BookUserMapper.class);
//    List<User> list = mapper.getAllUser();
//    System.out.println(list);
//    User user  = mapper.getUserStep("6");
//    System.out.println(user.getName());
//    System.out.println(user.getBook());
//    Book book = mapper.getBookUsersById("1");
//    System.out.println(book);
      Book book = mapper.getOnlyBookByBid("1");
      System.out.println(book.getName());
//    System.out.println(book);
  }
}
