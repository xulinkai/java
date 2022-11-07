package com.xulk.bean.selfEditor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc
 * @created by xlk on 2022/10/30 11:56
 */
public class Test {

	/**
	 * @Desc 自定义属性编辑器
	 * 步骤
	 * 1、自定义一个实现了PropertyEditorSupport接口的编辑器
	 * 2、让spring能够识别到此编辑器 自定义一个实现一个属性编辑器的注册器，实现了PropertyEditorRegistrar接口
	 * 3、让spring能够识别到对应的注册器，需要配置进去
	 */
	public static void selfEditor() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self-editor.xml");
		Customer bean = (Customer) ctx.getBean("customer");
		System.out.println(bean);
	}


}
