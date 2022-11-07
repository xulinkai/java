package com.xulk;

import com.xulk.bean.pack.PackageA;
import com.xulk.bean.xml.XmlA;
import com.xulk.bean.xml.XmlB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc
 */
public class SpringDemo {

	/**
	 * @Desc 扫描包
	 */
	public static void packageDemo() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.xulk.bean.pack");
		System.out.println(ac.getBean(PackageA.class));
	}

	/**
	 * @Desc xml文件
	 * xml方式配置的bean 都是GenericBeanDefinition
	 */
	public static void fileDemo() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlA xmlA = (XmlA) ctx.getBean("xmlA");
		System.out.println(xmlA);
		XmlB xmlB = ctx.getBean("xmlB", XmlB.class);
		System.out.println(xmlB);
	}



	public static void main(String[] args) {
		fileDemo();
	}

}
