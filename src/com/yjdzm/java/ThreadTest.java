package com.yjdzm.java;

/**
 * @author YaoJin
 * @create 2020-11-10 20:55
 */
class MyThread extends Thread {
    @Override
    public void run () {
        for (int i = 0; i < 100 ; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        // 这里还是主线程进行的, 创建了一个对象
        MyThread thread = new MyThread();
        // 这里才是创建了一个线程
        thread.start();
        System.out.println("Hello, YaoJin");
    }
}

