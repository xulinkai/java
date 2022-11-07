package com.xulk.bean.factoryMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryMethod {


	/**
	 * @Desc 执行是在 supplier的下面  AbstractAutowireCapableBeanFactory.createBeanInstance
	 */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("factory-method.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
        Person person2 = ac.getBean("person2", Person.class);
        System.out.println(person2);
    }
}
