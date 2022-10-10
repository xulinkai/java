package com.aggregation.mashibing.threadLocal;

/**
 * @Desc
 * @created by xlk on 2022/8/11 10:24
 */
public class ThreadLocalTest {

    /**
     * @Desc 定义一个全局变量 来存放线程需要的变量
     */
    public static ThreadLocal<Integer> ti = new ThreadLocal<>();

    public static void main(String[] args) {

        /*创建两个线程*/
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Double d = Math.random() * 10;
                /*存入当前线程独有的值*/
                ti.set(d.intValue());
                new A().get();
                new B().get();
            }).start();
        }
    }

    static class A {
        public void get() {
            /*取得当前线程所需要的值*/
            System.out.println(Thread.currentThread().getId() + "-" + ti.get());
        }
    }

    static class B {
        public void get() {
            /*取得当前线程所需要的值*/
            System.out.println(Thread.currentThread().getId() + "-" + ti.get());
        }
    }

}
