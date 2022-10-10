package com.aggregation.mashibing.threadLocal;

/**
 * @Desc
 * @created by xlk on 2022/8/11 10:27
 */
public class ThreadLocalDemo {

    /*把线程相关的部分内聚到 类里面  相当于map 每个类是对应key*/
    private static ThreadLocal<ThreadLocalDemo> t = new ThreadLocal<>();

    private ThreadLocalDemo() {
    }

    public static ThreadLocalDemo getThreadInstance() {
        ThreadLocalDemo threadLocalDemo = t.get();
        if (null == threadLocalDemo) {//当前线程无绑定的对象时，直接绑定一个新的对象
            threadLocalDemo = new ThreadLocalDemo();
            t.set(threadLocalDemo);
        }
        return threadLocalDemo;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
