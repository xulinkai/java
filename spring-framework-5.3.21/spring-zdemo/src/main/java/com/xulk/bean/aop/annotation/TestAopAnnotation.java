package com.xulk.bean.aop.annotation;

import com.xulk.bean.aop.annotation.config.SpringConfiguration;
import com.xulk.bean.aop.annotation.service.MyCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAopAnnotation {

	/**
	 * @Desc
	 *
	 * AspectJPointcutAdvisor
	 * AspectJPointcutAdvisor(AbstractAspectJAdvice advice)
	 * AbstractAspectJAdvice(Method aspectJAdviceMethod, AspectJExpressionPointcut pointcut, AspectInstanceFactory aspectInstanceFactory)
	 *
	 */
    public static void main(String[] args) throws NoSuchMethodException {
    	// 此类的构造方法中会注册一些inner postProcessor
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(SpringConfiguration.class);
        ac.refresh();
        MyCalculator bean = ac.getBean(MyCalculator.class);
        System.out.println(bean.add(1, 1));
    }

}
