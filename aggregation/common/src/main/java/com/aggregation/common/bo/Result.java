package com.aggregation.common.bo;

import com.aggregation.common.enums.http.HttpStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Result<T> implements Serializable {

    protected int code;

    protected String message;

    protected T data;

    public static <T> Result<T> ok() {
        return ok(HttpStatusEnum.OK.code(), null, null);
    }

    public static <T> Result<T> ok(String message) {
        return ok(HttpStatusEnum.OK.code(), message, null);
    }

    public static <T> Result<T> ok(T data) {
        return ok(HttpStatusEnum.OK.code(), "成功", data);
    }

    public static <T> Result<T> ok(String message, T data) {
        return ok(HttpStatusEnum.OK.code(), message, data);
    }

    public static <T> Result<T> ok(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> error() {
        return error(HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), null, null);
    }

    public static <T> Result<T> error(String message) {
        return error(HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), message, null);
    }

    public static <T> Result<T> error(T data) {
        return error(HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), "失败", data);
    }

    public static <T> Result<T> error(String message, T data) {
        return ok(HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), message, data);
    }

    public static <T> Result<T> error(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}


