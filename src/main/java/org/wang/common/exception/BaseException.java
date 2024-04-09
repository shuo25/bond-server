package org.wang.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.wang.common.enums.ResultEnum;

/**
 * 统一异常处理
 * Author: 18615
 * Date: 2024/4/9 20:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException{
    private ResultEnum responseCode;

    public BaseException(ResultEnum responseCode, String message) {
        super(message);

        setResponseCode(responseCode);
    }
}
