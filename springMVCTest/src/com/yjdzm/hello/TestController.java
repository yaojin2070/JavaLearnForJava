package com.yjdzm.hello;


import com.yjdzm.bean.User;
import org.springframework.context.ApplicationContext;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

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

  @RequestMapping(value="/up", method = RequestMethod.POST)
  public String testUp(String desc, MultipartFile uploadFile, HttpSession session) throws IOException{
    System.out.println(uploadFile);
    // 获取上传文件的名称
    String fileName = uploadFile.getOriginalFilename();
    System.out.println(fileName);
    String finalFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
    String path = session.getServletContext().getRealPath("img") + File.separator + finalFileName;
    System.out.println(path);
    File file = new File(path);

    System.out.println(file);
    uploadFile.transferTo(file);
    return "success";
  }

  @RequestMapping(value="/inter")
  public String interTest() {
    System.out.println("inter");
    return "success";
  }

  @RequestMapping(value="/error", method = RequestMethod.GET)
  public String errorTest() {
    int i = 1 / 0;
    return "success";
  }

  @RequestMapping(value="/getbean", method = RequestMethod.GET)
  public String beanTest(HttpSession session) {
    ServletContext servletContext = session.getServletContext();
    ApplicationContext ac = (ApplicationContext)servletContext.getAttribute("ac");
    User user = ac.getBean("user", User.class);
    System.out.println(user);
    return "success";
  }
}
