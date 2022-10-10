package com.aggregation.secret.advice;

import com.aggregation.secret.base.ResponseCode;
import com.aggregation.secret.base.SecretHttpMessage;
import com.aggregation.secret.dto.SecretDto;
import com.aggregation.secret.exceptions.ResultException;
import com.aggregation.secret.filter.SecretFilter;
import com.aggregation.secret.utils.EncryptUtils;
import com.aggregation.secret.utils.Md5Utils;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Objects;


/**
 * @description:
 * 这个 ResponseBodyAdvice 只支持 @ResponseBody 注解的 controller 方法，
 * 同样，RequestBodyAdvice 只支持带有 @RequestBody 注解的 controller 方法参数的方法，同时上报的数据必须是 json or xml
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class SecretRequestAdvice extends RequestBodyAdviceAdapter {

    /**
     * @Desc 判断代码是否需要被拦截
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        System.out.println("xlk");
        return true;
    }

    /**
     * @Desc supports()返回true时的前置处理
     */
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        //如果支持加密消息，进行消息解密。
        String httpBody;
        if (Boolean.TRUE.equals(SecretFilter.secretThreadLocal.get())) {
            httpBody = decryptBody(inputMessage);
        } else {
            httpBody = StreamUtils.copyToString(inputMessage.getBody(), Charset.defaultCharset());
        }
        //返回处理后的消息体给messageConvert
        return new SecretHttpMessage(new ByteArrayInputStream(httpBody.getBytes()), inputMessage.getHeaders());
    }

    /**
     * 解密消息体
     *
     * @param inputMessage 消息体
     * @return 明文
     */
    private String decryptBody(HttpInputMessage inputMessage) throws IOException {
        InputStream encryptStream = inputMessage.getBody();
        String requestBody = StreamUtils.copyToString(encryptStream, Charset.defaultCharset());

        // 校验参数
        HttpHeaders headers = inputMessage.getHeaders();
        Preconditions.checkArgument(!headerArgsIsInvalid(headers), "请求解密参数错误，clientType、timestamp、salt、signature等参数传递是否正确传递");

        // 验签
        SecretDto secretDto = JSON.parseObject(requestBody, SecretDto.class);
        String data = secretDto.getData();
        String privateKey = SecretFilter.clientPrivateKeyThreadLocal.get();
        Preconditions.checkArgument(signIsValid(headers, privateKey, data), "验签失败，请确认加密方式是否正确");

        try {
            // 解密
            String decrypt = EncryptUtils.aesDecrypt(data, privateKey);
            if (StringUtils.isEmpty(decrypt)) {
                decrypt = "{}";
            }
            return decrypt;
        } catch (Exception e) {
            log.error("error: ", e);
        }
        throw new ResultException(ResponseCode.SECRET_API_ERROR, "解密失败");
    }

    /**
     * @Desc 验签是否有效
     */
    private boolean signIsValid(HttpHeaders headers, String privateKey, String data) {
        String timestamp = String.valueOf(Objects.requireNonNull(headers.get("timestamp")).get(0));
        String salt = String.valueOf(Objects.requireNonNull(headers.get("salt")).get(0));
        String signature = String.valueOf(Objects.requireNonNull(headers.get("signature")).get(0));
        String newSignature = "";
        if (StringUtils.isNotBlank(privateKey)) {
            newSignature = Md5Utils.generateSignature(timestamp + salt + data + privateKey);
        }
        return Objects.equals(newSignature, signature);
    }

    /**
     * @Desc header 是否有效
     */
    private boolean headerArgsIsInvalid(HttpHeaders headers) {
        return CollectionUtils.isEmpty(headers.get("clientType")) || CollectionUtils.isEmpty(headers.get("timestamp")) || CollectionUtils.isEmpty(headers.get("salt")) || CollectionUtils.isEmpty(headers.get("signature"));
    }

}
