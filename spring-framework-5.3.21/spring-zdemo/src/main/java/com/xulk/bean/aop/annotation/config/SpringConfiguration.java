package com.xulk.bean.aop.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.xulk.bean.aop.annotation")
@EnableAspectJAutoProxy
public class SpringConfiguration { }