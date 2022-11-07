package com.xulk.bean.beanFactoryPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc
 * @created by xlk on 2022/10/30 11:54
 */
public class Test {

	/**
	 * @Desc 自定义beanFactoryPostProcessor
	 */
	public static void beanFactoryPostProcessor(){
		new AnnotationConfigApplicationContext("com.xulk.bean.beanFactoryPostProcessor");
	}

}
