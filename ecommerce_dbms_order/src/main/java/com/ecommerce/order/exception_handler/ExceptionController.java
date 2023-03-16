package com.ecommerce.order.exception_handler;


import com.ecommerce.common.exception.MyBusinessException;
import com.ecommerce.common.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// @ControllerAdvice
@RestControllerAdvice  // NOTE: **必须是@RestControllerAdvice，否则就要在买个controller上面加@ResponseBody， RestControllerAdvice = ControllerAdvice + ResponseBody
public class ExceptionController {
    // field validation error handler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    // @ResponseBody  // 如果不是@RestControllerAdvice，就要加上这个， 因为Result对象不会被自动转换成json
    // public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
                    String fieldName = ((FieldError) err).getField();
                    String errorMessage = err.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                }
        );
        // return errors;
        return new Result().error(HttpStatus.BAD_REQUEST.value(), "Bad request.", errors);
    }

    // Note: 上面的是根据转换后的数据做校验， 但是比如Integer id获得String 'dd'， 不会被上面捕获)
    //   incorrect field type from front end being converted in controller to DTO,
    //      the error will be caught here, but not in TypeMismatchException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String errorMessage = e.getMessage();
        System.out.println("errorMessage: " + errorMessage);
        Map<String, String> errors = new HashMap<>();
        errors.put("HttpMessageNotReadableException", errorMessage);
        return new Result().error(HttpStatus.BAD_REQUEST.value(), "HttpMessageNotReadableException", errors);
    }

    @ExceptionHandler(MyBusinessException.class)
    public Result handleMyBusinessException(MyBusinessException e) {
        System.out.println("order 捕获到业务异常: " + e);
        return new Result().error(e);
    }

    // catch all other exceptions
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Throwable.class})
    public Result handleException(Throwable e) {
        System.out.println("order 捕获到异常: " + e);
        String errorMessage = e.getMessage();
        Map<String, String> errors = new HashMap<>();
        errors.put("Exception", e.getMessage());
        errors.put("localizedMessage", e.getLocalizedMessage());
        errors.put("stackTrace", Arrays.toString(e.getStackTrace()));
        return new Result().error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Exception", errors);
    }
}
