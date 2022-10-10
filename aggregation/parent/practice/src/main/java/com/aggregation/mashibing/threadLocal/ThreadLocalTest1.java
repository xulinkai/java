package com.aggregation.mashibing.threadLocal;

import java.util.Objects;

/**
 * @Desc
 * @created by xlk on 2022/8/11 10:24
 */
public class ThreadLocalTest1 {

    /**
     * @Desc 定义一个全局变量 来存放线程需要的变量
     */
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                threadLocal.set("i:" + finalI);
                new A().get();
                new B().get();
            }).start();
        }
        System.out.println("xlk");
        threadLocal.remove();
    }

    static class A {
        public void get() {
            System.out.println(Thread.currentThread().getId() + "-" + threadLocal.get());
        }
    }

    static class B {
        public void get() {
            if(!Objects.equals("i:1", threadLocal.get())){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                threadLocal.remove();
            }
            System.out.println(Thread.currentThread().getId() + "-" + threadLocal.get());
        }
    }

}
