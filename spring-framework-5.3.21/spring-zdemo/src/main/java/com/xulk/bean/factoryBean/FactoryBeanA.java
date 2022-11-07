package com.xulk.bean.factoryBean;

/**
 * @Desc
 * @created by xlk on 2022/10/26 19:53
 */
public class FactoryBeanA {

	private  String name;

	@Override
	public String toString() {
		return "FactoryBeanA{" +
				"name='" + name + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
