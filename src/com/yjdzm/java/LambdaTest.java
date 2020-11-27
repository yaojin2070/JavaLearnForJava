package com.yjdzm.java;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author YaoJin
 * @create 2020-11-27 21:27
 * @description: Lambda练习, 接口实例简写, java学习第33天
 *  * java内置的4大核心函数式接口
 *  *
 *  * 消费型接口 Consumer<T>     void accept(T t)
 *  * 供给型接口 Supplier<T>     T get()
 *  * 函数型接口 Function<T,R>   R apply(T t)
 *  * 断定型接口 Predicate<T>    boolean test(T t)
 */
public class LambdaTest {
  // 语法格式一 无参数, 无返回值
  @Test
  public void test1() {
    // 原始写法
    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("一个失败的我");
      }
    };
    r1.run();

    // 简写方式
    Runnable r2 = () -> System.out.println("反正也没人看");
    r2.run();
  }

  // 语法格式二 需要一个参数, 但是没有返回值
  @Test
  public void test2 () {
    // 原始写法
    Consumer<String> con = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };
    con.accept("生儿为人, 我很抱歉");

    // 简化写法
    Consumer<String> con1 = s -> System.out.println(s);
    con1.accept("12点了, 开始网抑云了");
  }
}
