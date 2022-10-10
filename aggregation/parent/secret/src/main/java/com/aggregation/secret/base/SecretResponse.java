package com.aggregation.secret.base;

import com.aggregation.secret.utils.EncryptUtils;
import lombok.Data;

/**
 * @description:
 */
@Data
public class SecretResponse {
    /**
     * 加密数据
     */
    private Object data;
    /**
     * 加密结果
     */
    private Integer code;
    /**
     * 签名，用于验签
     */
    private String signature;

    private String msg;

    private long timestamp;

    private int salt;

    public static SecretResponse success(Object data) {
        return newInstance(data, 200, "success");
    }

    public static SecretResponse success(Object data, long timestamp, int salt, String signature) {
        return newInstance(data, "", 200, timestamp, salt, signature);
    }

    public static SecretResponse fail(Object data) {
        return newInstance(data, 400, "");
    }

    public static SecretResponse fail(Integer code, Object data, String msg) {
        return newInstance(data, code, msg);
    }

    public static SecretResponse fail(String msg, long timestamp, int salt, String signature) {
        return newInstance("", msg, 400, timestamp, salt, signature);
    }

    public static SecretResponse failWithEncrypt(String msg, long timestamp, int salt, String signature) {
        return newInstance("", msg, 400, timestamp, salt, signature);
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    private static SecretResponse newInstance(Object data, Integer status, String msg) {
        long timestamp = System.currentTimeMillis() / 1000;
        int salt = EncryptUtils.genSalt();
        SecretResponse secretResponse = new SecretResponse();
        secretResponse.setData(data);
        secretResponse.setMsg(msg);
        secretResponse.setCode(status);
        secretResponse.setSalt(salt);
        secretResponse.setTimestamp(timestamp);
        return secretResponse;
    }


    private static SecretResponse newInstance(Object data, String msg, Integer status, long timestamp, int salt, String signature) {
        SecretResponse secretResponse = new SecretResponse();
        secretResponse.setData(data);
        secretResponse.setMsg(msg);
        secretResponse.setCode(status);
        secretResponse.setTimestamp(timestamp);
        secretResponse.setSalt(salt);
        secretResponse.setSignature(signature);
        return secretResponse;
    }
}
