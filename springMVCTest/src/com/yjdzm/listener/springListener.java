package com.yjdzm.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author YaoJin
 * @create 2020-12-30 18:21
 * @description
 */
public class springListener implements ServletContextListener {
  public springListener() {
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("ac", ac);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
