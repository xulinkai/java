package com.aggregation.secret.filter;

import com.aggregation.secret.constants.SecretConstant;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @description: 过滤器
 */
public class SecretFilter implements Filter {

    public static ThreadLocal<Boolean> secretThreadLocal = new ThreadLocal<>();
    public static ThreadLocal<String> clientPrivateKeyThreadLocal = new ThreadLocal<>();

    @Value("${secret.privateKey.h5}")
    private String h5Key;

    @Value("${secret.privateKey.default}")
    private String defaultKey;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 免加密
        if (!request.getRequestURI().startsWith(SecretConstant.PREFIX)) {
            secretThreadLocal.set(Boolean.FALSE);
        } else {
            // 加密，先只考虑POST情况
            secretThreadLocal.set(Boolean.TRUE);
            // 简单获取对应加密的私钥
            String privateKey = ("H5".equalsIgnoreCase(Objects.requireNonNull(request.getHeader("clientType")))) ? h5Key : defaultKey;
            clientPrivateKeyThreadLocal.set(privateKey);
        }
        filterChain.doFilter(request, response);
    }
}
