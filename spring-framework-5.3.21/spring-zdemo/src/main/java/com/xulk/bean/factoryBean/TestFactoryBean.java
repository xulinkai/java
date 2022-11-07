package com.xulk.bean.factoryBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc
 * @created by xlk on 2022/10/30 11:55
 */
public class TestFactoryBean {


	/**
	 * @Desc factory-bean
	 * 实现了FactoryBean接口的对象，容器启动后还未创建，在获取的时候才会创建(容器启动后 只是创建了factoryBean子类对象)。
	 */
	public static void factoryBeanDemo() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("factory-bean.xml");

		System.out.println(ctx.getBean("myFactoryBean").getClass().getName());

		System.out.println(ctx.getBean(BeanFactory.FACTORY_BEAN_PREFIX + "myFactoryBean").getClass().getName());

		System.out.println(ctx.getBean("myFactoryBean").getClass().getName());
	}

	public static void main(String[] args) {
		factoryBeanDemo();
	}


}
