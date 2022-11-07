package com.xulk.bean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @created by xlk on 2022/10/26 19:52
 */

@Configuration
public class MyConfiguration {

	@Bean
	public ConfigurationA configurationA(){
		return new ConfigurationA();
	}

}
