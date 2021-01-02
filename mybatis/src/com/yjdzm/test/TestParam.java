package com.yjdzm.test;

import com.yjdzm.bean.User;
import com.yjdzm.mapper.ParamMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YaoJin
 * @create 2021-01-02 20:32
 * @description
 */
public class TestParam {
  @Test
  public void  test() throws IOException {
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动处理事务
    ParamMapper mapper = sqlSession.getMapper(ParamMapper.class);
//    User user = new User(null, "YaoJin", "121212", "121212", "121212121");
//    mapper.insertUser(user);
//    System.out.println(user.getId());

      // 2
//     User user = mapper.getUserByNameAndId( 6, "遥近");
//      System.out.println(user);
      // 3
//    Map<String, Object> map = new HashMap<>();
//    map.put("id", "6");
//    map.put("name", "遥近");
//    User user = mapper.getUserByMap(map);
//    System.out.println(user);

      //4
      User user = mapper.getUserByParam("6", "遥近");
    System.out.println(user);
  }
}
