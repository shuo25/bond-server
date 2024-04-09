package org.wang.common.response;

import lombok.Data;
import org.wang.common.constant.CommonConstant;
import org.wang.common.enums.ResultEnum;
import org.wang.common.exception.BaseException;

/**
 * Author: 18615
 * Date: 2024/3/18 20:41
 */
@Data
public class Result<T> {
    /**
     * 成功标志
     */
    private boolean success = true;
    /**
     * 返回代码
     */
    private int code;
    /**
     * 返回处理消息
     */
    private String message;
    /**
     * 返回数据对象 data
     */
    private T data;
    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();
    public Result() {
    }
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static<T> Result<T> ok(T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultEnum.SC_OK_200.getCode());
        r.setData(data);
        return r;
    }

    public static<T> Result<T> error(Integer code, String message) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(code);
        r.setMessage(message);
        r.setData(null);
        return r;
    }

    public static<T> Result<T> error(ResultEnum responseCode, Exception e) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(responseCode.getCode());
        r.setMessage(e.getMessage());
        r.setData(null);
        return r;
    }
}
