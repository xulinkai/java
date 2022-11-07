package com.xulk.bean.xml;

/**
 * @Desc
 */
public class XmlA {

	private String name;
	private int age;
	private XmlB xmlB;

	public XmlA(String name, int age, XmlB xmlB) {
		this.name = name;
		this.age = age;
		this.xmlB = xmlB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public XmlB getFood() {
		return xmlB;
	}

	public void setFood(XmlB xmlB) {
		this.xmlB = xmlB;
	}

	@Override
	public String toString() {
		return "XmlA{" +
				"name='" + name + '\'' +
				", age=" + age +
				", xmlB=" + xmlB +
				'}';
	}
}
