package com.yjdzm.mapper;

import com.yjdzm.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author YaoJin
 * @create 2021-01-02 18:03
 * @description
 */
public interface ParamMapper {
  //添加员工信息
  void insertUser(User user);

  User getUserByNameAndId(Integer id, String name);

  User getUserByMap(Map<String, Object> map);

  User getUserByParam(@Param("uid") String id, @Param("uname") String name);
}
