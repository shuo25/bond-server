package org.wang.common.enums;

/**
 * 返回信息枚举
 * @author wangshuo
 * @create 2024/4/2 9:28
 */
public enum  ResultEnum {
    SC_OK_200(200, "操作成功"),
    BAD_REQUEST(400, "失败的请求"),

    UNAUTHORIZED(401, "未授权"),

    FORBIDDEN(403, "禁止访问"),

    NOT_FOUND(404, "请求找不到"),

    NOT_ACCEPTABLE(406, "不可访问"),

    CONFLICT(409, "冲突"),

    ERROR(500, "服务发生异常");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
