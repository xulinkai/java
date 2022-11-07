package com.xulk.bean.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class MyTest {
    public static void main(String[] args) {
        String proxyObjectLocalPath = "/Users/xulinkai/java/repository_github/java/spring-framework-5.3.21/spring-zdemo/src/main/java/com/xulk/bean/proxy/proxyObject";
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, proxyObjectLocalPath);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyCalculator.class);
        enhancer.setCallback(new MyCglib());
        MyCalculator myCalculator = (MyCalculator) enhancer.create();
        myCalculator.add(1,1);
        System.out.println(myCalculator.getClass());
    }
}