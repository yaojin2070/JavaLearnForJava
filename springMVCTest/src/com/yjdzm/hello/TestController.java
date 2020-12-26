package com.yjdzm.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * @author YaoJin
 * @create 2020-12-25 21:01
 * @description
 */
@Controller
public class TestController {
  @RequestMapping(value="/hello/{id}", method = RequestMethod.GET)
  public String helloTest(@PathVariable("id") Integer id) {
    System.out.println(id);
    System.out.println("SUCCESS");
    return "success";
  }
  @RequestMapping(value="/test1", method = RequestMethod.POST)
  public String postTest() {
    System.out.println("POST");
    return "success";
  }

  @RequestMapping(value="/test1", method = RequestMethod.PUT)
  public String putTest() {
    System.out.println("PUT");
    return "success";
  }

  @RequestMapping(value="/test1", method = RequestMethod.DELETE)
  public String deleteTest() {
    System.out.println("DELETE");
    return "success";
  }
}