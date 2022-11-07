package com.xulk.bean.aop.xml;

import com.xulk.bean.aop.xml.service.MyCalculator;
import com.xulk.bean.aop.xml.util.LogUtil;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.Properties;

public class TestAopXml {


	/**
	 * @Desc
	 *
	 * AspectJPointcutAdvisor
	 * AspectJPointcutAdvisor(AbstractAspectJAdvice advice)
	 * AbstractAspectJAdvice(Method aspectJAdviceMethod, AspectJExpressionPointcut pointcut, AspectInstanceFactory aspectInstanceFactory)
	 *
	 */
    public static void main(String[] args) throws Exception {
        //saveGeneratedCGlibProxyFiles(System.getProperty("user.dir")+"/proxy");
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        MyCalculator bean = ac.getBean(MyCalculator.class);
        System.out.println(bean);
		System.out.println(ac.getBean(LogUtil.class));
        bean.add(1,1);
        bean.sub(1,1);
    }

    /**
     * @Desc 保存代理对象的生成路径
     */
    public static void saveGeneratedCGlibProxyFiles(String dir) throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);//dir为保存文件路径
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
    }

}
