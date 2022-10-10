package com.aggregation.secret.config;

import com.aggregation.secret.filter.SecretFilter;
import com.aggregation.secret.constants.SecretConstant;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;


/**
 * @description:
 */
@Configuration
public class WebConfig {

    @Bean
    public Filter secretFilter() {
        return new SecretFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("secretFilter"));
        registration.setName("secretFilter");
        registration.addUrlPatterns(SecretConstant.PREFIX + "/*");
        registration.setOrder(1);
        return registration;
    }

}
