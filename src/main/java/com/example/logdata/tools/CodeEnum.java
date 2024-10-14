package com.example.logdata.tools;
/*
    返回状态枚举类
 */
public enum CodeEnum {

    SUCCESS(true, 1001, "成功"), Fail(false, 1002, "失败");

    private final Boolean success;
    private final Integer code;
    private final String message;

    CodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String  getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return "CodeEnum {success=" + success + ", code=" + code + ", message=" + message + "}";
    }

}
