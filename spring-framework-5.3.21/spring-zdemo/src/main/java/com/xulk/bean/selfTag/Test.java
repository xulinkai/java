package com.xulk.bean.selfTag;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc
 * @created by xlk on 2022/10/30 11:57
 */
public class Test {

	/**
	 * @Desc 自定义标签
	 * 自定义一个标签 自定义一个<xlk:user username email  age >
	 * 步骤：
	 * 1、创建一个标签解析类parser
	 * 2、创建一个解析器处理类 handler，在init方法中添加parser类
	 * 3、创建一个spring.handlers配置文件，让spring能够完成加载工作
	 */
	public static void selfTag() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self-tag.xml");
		// spring为bean生成的beanName 默认规则是 有id则使用id，无id则使用类名且首字母小写
		SelfTagUser selfTagUser = (SelfTagUser) ctx.getBean("001");
		System.out.println(String.format("username:%s email:%s", selfTagUser.getUsername(), selfTagUser.getEmail()));
	}



}
