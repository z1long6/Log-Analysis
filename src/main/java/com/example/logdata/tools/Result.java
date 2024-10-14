package com.example.logdata.tools;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/*
    统一返回类
 */
@Data
public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data;

    // 操作执行成功
    public static Result success() {
        Result result = new Result();
        result.setSuccess(CodeEnum.SUCCESS.getSuccess());
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setMessage(CodeEnum.SUCCESS.getMessage());
        return result;
    }

    // 操作执行失败
    public static Result error() {
        Result result = new Result();
        result.setSuccess(CodeEnum.Fail.getSuccess());
        result.setCode(CodeEnum.Fail.getCode());
        result.setMessage(CodeEnum.Fail.getMessage());
        return result;
    }

    // 自定义result
    public static Result setResult(CodeEnum codeEnum) {
        Result result = new Result();
        result.setSuccess(codeEnum.getSuccess());
        result.setCode(codeEnum.getCode());
        result.setMessage(codeEnum.getMessage());
        return result;
    }

    // 返回数据
    public Result data(String key, Object value) {
        if (data == null) {
            data = new HashMap<>();
            data.put(key, value);
        }
        return this;
    }

    public Result data(Map<String, Object> data) {
        this.data = data;
        return this;
    }
}
