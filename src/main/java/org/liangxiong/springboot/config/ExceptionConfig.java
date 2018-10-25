package org.liangxiong.springboot.config;

import org.liangxiong.springboot.controller.CustomErrorType;
import org.liangxiong.springboot.controller.IndexController;
import org.liangxiong.springboot.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liangxiong
 * @Description 对于特定Controller和Exception定置化响应地json数据
 * @Date 2018-10-21
 * @Time 11:31
 */
@ControllerAdvice(basePackageClasses = IndexController.class)
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);

    /**
     * 针对特定异常类型,定制化响应消息体
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Exception ex) {
        // 异常信息记录到日志文件
        logger.error(ExceptionUtil.getFullStackTrace(ex));
        // 异常信息以JSON形式返回
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage(), false), status);
    }

    /**
     * 获取HTTP状态
     *
     * @param request HTTP请求
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}