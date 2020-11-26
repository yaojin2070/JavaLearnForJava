package com.yjdzm.exer;

/**
 * @author YaoJin
 * @create 2020-11-11 10:31
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 创建匿名子类
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("您好");
                }
            }
        }.start();
    }
}
