package com.yjdzm.mapper;

import com.yjdzm.bean.User;

import java.util.List;

/**
 * @author YaoJin
 * @create 2021-01-01 19:55
 * @description
 */
public interface UserMapper {
  // 获得单个用户
  User getUserById(String id);
  // 获取用户列表
  List<User> getAllUser();
  // 添加用户
  void addUser(User user);
  // 修改用户
  void editUser(User user);

  // 删除用户
  Boolean deleteUser(String id);

}
