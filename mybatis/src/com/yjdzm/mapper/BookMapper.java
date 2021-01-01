package com.yjdzm.mapper;

import com.yjdzm.bean.Book;

/**
 * @author YaoJin
 * @create 2021-01-01 10:12
 * @description
 */
public interface BookMapper {
  Book getBookById(String id);
}
