package com.aggregation.secret.advice;

import com.aggregation.secret.base.ResponseCode;
import com.aggregation.secret.base.SecretResponse;
import com.aggregation.secret.base.SecretResult;
import com.aggregation.secret.filter.SecretFilter;
import com.aggregation.secret.utils.EncryptUtils;
import com.aggregation.secret.utils.Md5Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @description:
 * 这个 ResponseBodyAdvice 只支持 @ResponseBody 注解的 controller 方法，
 * 同样，RequestBodyAdvice 只支持带有 @RequestBody 注解的 controller 方法参数的方法，同时上报的数据必须是 json or xml
 */
@Slf4j
@ControllerAdvice
public class SecretResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Desc 是否需要拦截
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * @Desc 前处理方法 supports()方法返回true时执行 对响应体进行加密
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 判断是否需要加密
        Boolean respSecret = SecretFilter.secretThreadLocal.get();
        String secretKey = SecretFilter.clientPrivateKeyThreadLocal.get();
        // 清理本地缓存
        SecretFilter.secretThreadLocal.remove();
        SecretFilter.clientPrivateKeyThreadLocal.remove();
        if (null != respSecret && respSecret) {
            if (o instanceof SecretResult) {
                // 外层加密级异常
                if (ResponseCode.SECRET_API_ERROR == ((SecretResult) o).getCode()) {
                    return SecretResponse.fail(((SecretResult) o).getCode(), ((SecretResult) o).getData(), ((SecretResult) o).getMsg());
                }
                // 业务逻辑
                try {
                    // 使用FastJson序列号会导致和之前的接口响应参数不一致，后面会重点讲到
                    String data = EncryptUtils.aesEncrypt(objectMapper.writeValueAsString(o), secretKey);
                    // 增加签名
                    long timestamp = System.currentTimeMillis() / 1000;
                    int salt = EncryptUtils.genSalt();
                    String dataNew = timestamp + "" + salt + "" + data + secretKey;
                    String newSignature = Md5Utils.generateSignature(dataNew);
                    return SecretResponse.success(data, timestamp, salt, newSignature);
                } catch (Exception e) {
                    log.error("beforeBodyWrite error:", e);
                    return SecretResponse.fail(ResponseCode.SECRET_API_ERROR, "", "服务端处理结果数据异常");
                }
            }
        }
        return o;
    }
}

