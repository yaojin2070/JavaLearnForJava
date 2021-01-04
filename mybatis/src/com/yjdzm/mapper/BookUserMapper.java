package com.yjdzm.mapper;

import com.yjdzm.bean.Book;
import com.yjdzm.bean.User;

import java.util.List;

/**
 * @author YaoJin
 * @create 2021-01-03 11:21
 * @description
 */
public interface BookUserMapper {
  List<User> getAllUser();
  User getUserStep(String id);
  Book getBookUsersById(String id);
  List<User> getUserByBid(String id);
  Book getOnlyBookByBid(String id);
}
