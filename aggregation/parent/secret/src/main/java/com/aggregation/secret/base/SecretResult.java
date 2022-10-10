package com.aggregation.secret.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 统一返回数据实体
 */
@Data
public class SecretResult<T> implements Serializable {

    private int code;

    private T data;

    private String msg;

    private int salt;

    private String signature;

    public SecretResult<T> fail(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public SecretResult<T> success(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }
}
