package com.aggregation.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/28 下午5:27
 */
@WebFilter(urlPatterns = "/*", filterName = "MyFilter")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilter init.................");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter before.............");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getParameter("name") + " myFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter after.............");
    }

    @Override
    public void destroy() {
        System.out.println("myFilter destroy.............");
    }

}
