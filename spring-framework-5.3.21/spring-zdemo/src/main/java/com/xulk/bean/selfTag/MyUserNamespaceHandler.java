package com.xulk.bean.selfTag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyUserNamespaceHandler extends NamespaceHandlerSupport {


	/**
	 * @Desc 源码解析xml的时候 会调用init方法，将此schema下有哪些标签注册进去
	 */
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new MyUserBeanDefinitionParser());
	}

}
