package com.xulk.bean.pack;

import org.springframework.stereotype.Component;

/**
 * @Desc
 */
@Component
public class PackageA {

	private String name;
	private int age;
	private PackageB packageB;

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

	public PackageB getPackageB() {
		return packageB;
	}

	public void setPackageB(PackageB packageB) {
		this.packageB = packageB;
	}
}
