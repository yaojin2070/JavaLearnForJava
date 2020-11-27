package com.yjdzm.java;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author YaoJin
 * @create 2020-11-27 22:22
 * @description: Lambda 构造器以及数组引入
 */
public class LambdaTest2 {
  // 构造器引入, 以Supplier接口为例子, Supplier接口返回一个对应泛型的实例
  // 原始
  @Test
  public void test1 () {
    Supplier<Employee> sup = new Supplier<Employee>() {
      @Override
      public Employee get() {
        return new Employee();
      }
    };
    // 构造器引用
    Supplier<Employee> sup1 = () -> new Employee();
    // 方法引用
    Supplier<Employee>  sup2 = Employee :: new;
    System.out.println(sup.get());
    System.out.println(sup1.get());
    System.out.println(sup2.get());
  }

  //Function中的R apply(T t) * 函数型接口 Function<T,R>   R apply(T t)
  @Test
  public void test2() {
    Function<Integer, Employee> fun1 = id -> new Employee(id);
    Employee employee = fun1.apply(1001);
    System.out.println(employee);

    // 简化写法
    Function<Integer, Employee> fun2 = Employee :: new;
    Employee employee1 = fun2.apply(1002);
    System.out.println(employee1);
  }

}
