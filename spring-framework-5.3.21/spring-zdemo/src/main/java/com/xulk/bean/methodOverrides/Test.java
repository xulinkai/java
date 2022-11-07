package com.xulk.bean.methodOverrides;

import com.xulk.bean.methodOverrides.lookup.FruitPlate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc
 * @created by xlk on 2022/10/30 11:56
 */
public class Test {

	/**
	 * spring中默认的对象都是单例的，spring会在一级缓存中持有该对象，方便下次直接获取，
	 * 那么如果是原型作用域的话，会创建一个新的对象
	 * 如果想在一个单例模式的bean下引用一个原型模式的bean,在此时就需要引用lookup-method标签来解决此问题
	 * 不然缓存单例bean的时候会把引用的原型bean也会缓存起来，每次通过单例bean获取原型bean的时候，获取到的是同一个bean
	 *
	 * 通过拦截器的方式每次需要的时候都去创建最新的对象，而不会把原型对象缓存起来，
	 */
	public static void lookUp(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("method-override.xml");
		FruitPlate apple = (FruitPlate) ctx.getBean("fruitplate1");
		// 这里的apple是动态代理后的对象 调用getFruit方法的时候 会被拦截
		System.out.println(apple.getFruit());
		FruitPlate banana = (FruitPlate) ctx.getBean("fruitplate2");
		System.out.println(banana.getFruit());
	}

}
