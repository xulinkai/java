package com.xulk.bean.resolveBeforeInstantiation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @Desc 在实例化之前 返回一个自定义的代理对象
	 */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("resolve-before-instantiation.xml");
        BeforeInstantiation bean = ac.getBean(BeforeInstantiation.class);
        bean.doSomeThing();
    }
}
