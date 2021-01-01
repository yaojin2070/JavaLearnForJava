package com.yjdzm.test;

import com.yjdzm.bean.User;
import com.yjdzm.mapper.UserMapper;
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
 * @create 2021-01-01 20:23
 * @description
 */
public class TestCURD {
  @Test
  public void testCRUD() throws IOException {
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    //SqlSession sqlSession = sqlSessionFactory.openSession();//需要手动处理事务
    SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动处理事务
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		User user = userMapper.getUserById("1");
//		System.out.println(user);
    //测试：获取所有的员工信息
//		List<User> list = userMapper.getAllUser();
//		System.out.println(list);
    //测试：添加员工信息
//    userMapper.addUser(new User(null, "遥近", "123456", "FOSHAN", "17688223434"));
//		sqlSession.commit();//提交事务
    //测试：修改员工信息
//    userMapper.editUser(new User(6, "遥近", "12345611", "FoShan", "17688223434"));
    //测试：删除员工信息
	Boolean i = userMapper.deleteUser("5");
		System.out.println("result:"+i);
    //select 字段名 from 表名 where 条件 group by 字段名 having 条件 order by 字段名 desc/asc limit index,pageSize
  }

}
