package com.xulk.bean.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc
 * @created by xlk on 2022/10/30 11:55
 */
public class TestConfiguration {

	/**
	 * @Desc configuration-bean
	 */
	public static void configurationDemo() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.xulk.bean.configuration");
		System.out.println(ac.getBean(ConfigurationA.class));
	}


	public static void main(String[] args) {
		configurationDemo();
	}
}
