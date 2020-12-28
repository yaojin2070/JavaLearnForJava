package com.yjdzm.hello;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.http.HttpSession;
import java.io.*;

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
  public String postTest(String username) {
    System.out.println(username);
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
  @RequestMapping(value="/test2", method = RequestMethod.POST)
  public String Test2(@RequestParam(value = "name", required = true) String username, String password) {
    System.out.println(username);
    return "success";
  }

  @RequestMapping(value="/down")
  public ResponseEntity<byte[]> downTest(HttpSession session) throws Exception {
    String imgPath = session.getServletContext().getRealPath("img");
    String finalPath = imgPath + File.separator + "pc-index-renfa-item03.gif";
    System.out.println(imgPath);
    InputStream is = new FileInputStream(finalPath);
    // available 获取输入流的所获取的文件最大字节数
    byte[] b = new byte[is.available()];
    is.read(b);
    // 设置请求头
    HttpHeaders header = new HttpHeaders();
    header.add("Content-Disposition", "attachment;filename=feiwen.gif");
    // 设置响应状态
    HttpStatus statusCode = HttpStatus.OK;
    ResponseEntity<byte[]> entity = new ResponseEntity<>(b, header, statusCode);
    return entity;
  }
}
