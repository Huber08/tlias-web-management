package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获所有未处理的异常
     * @param e 异常对象
     * @return 统一返回结果
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("系统异常: ", e);
        return Result.error("服务器内部错误，请联系管理员");
    }

    /**
     * 捕获运行时异常
     * @param e 运行时异常
     * @return 统一返回结果
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e) {
        log.error("运行时异常: ", e);
        return Result.error(e.getMessage() != null ? e.getMessage() : "运行时错误");
    }

    /**
     * 捕获非法参数异常
     * @param e 非法参数异常
     * @return 统一返回结果
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("参数校验异常: {}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 捕获JSON解析异常（包括数值溢出、格式错误等）
     * @param e JSON解析异常
     * @return 统一返回结果
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.warn("请求数据格式错误: {}", e.getMessage());

        String errorMessage = "请求数据格式错误";

        if (e.getMessage() != null) {
            String message = e.getMessage();

            // 数值溢出错误
            if (message.contains("Overflow") && message.contains("Integer")) {
                errorMessage = "数值超出范围，请检查输入数据（如薪资等数值字段）";
            }
            // 反序列化错误
            else if (message.contains("Cannot deserialize")) {
                // 提取更具体的错误信息
                if (message.contains("java.lang.Integer")) {
                    errorMessage = "整数类型数据格式错误或超出范围";
                } else if (message.contains("java.lang.Long")) {
                    errorMessage = "长整数类型数据格式错误";
                } else if (message.contains("java.lang.Double")) {
                    errorMessage = "浮点数类型数据格式错误";
                } else {
                    errorMessage = "数据格式不正确，请检查输入数据";
                }
            }
            // 缺少必需字段
            else if (message.contains("Required request body is missing")) {
                errorMessage = "请求体不能为空";
            }
        }

        return Result.error(errorMessage);
    }
}
