package org.wang.common.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wang.common.enums.ResultEnum;
import org.wang.common.response.Result;

import java.net.BindException;

/**
 * 全局异常处理类
 * Author: 18615
 * Date: 2024/4/9 20:13
 */
@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {
    /**
     * 处理BaseException
     *
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public Result<?> handlerGlobalException(HttpServletResponse response, BaseException e) {
        log.error("请求异常：", e);
        response.setStatus(e.getResponseCode().getCode());

        return Result.error(e.getResponseCode(), e);
    }

    /**
     * 处理Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handlerException(Exception e) {
        log.error("请求异常：", e);

        return Result.error(ResultEnum.ERROR, e);
    }
}
