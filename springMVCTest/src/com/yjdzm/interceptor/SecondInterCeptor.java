package com.yjdzm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YaoJin
 * @create 2020-12-29 20:38
 * @description
 */
public class SecondInterCeptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("2preHandle");
    //拦截是否
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    // 如果有错误, 这个不会执行
    System.out.println("2postHandle");
  }


  /*
  * 当多个拦截器时候:
  * preHandle: 按照拦截器数组的正向顺序执行
  * postHandle, afterCompletion 反向
  *
  * preHandle的值不同
  * 1 2 都返回false ,只有第一个的preHandle 执行
  * 1 true 2 false 两个preHandle执行, postHandle 都不执行, afterCompletion执行第一个
  * 1 false 2true ,只有第一个的preHandle 执行
  * 以此类推的规则
  * */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    // preHandle -> postHandle-> afterCompletion
    System.out.println("2afterCompletion");
  }

}
