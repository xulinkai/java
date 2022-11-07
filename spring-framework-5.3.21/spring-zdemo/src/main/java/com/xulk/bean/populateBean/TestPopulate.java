package com.xulk.bean.populateBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPopulate {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("populate-bean.xml");
        ac.close();
    }
}
