package com.xulk.bean.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Desc
 */
public class MyFactoryBean implements FactoryBean<FactoryBeanA> {


	@Override
	public FactoryBeanA getObject() throws Exception {
		return new FactoryBeanA();
	}

	@Override
	public Class<?> getObjectType() {
		return FactoryBeanA.class;
	}

}
