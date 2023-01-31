package com.ecommerce.product.exception_handler;


import com.ecommerce.common.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

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
        Map<String, String> errors = new HashMap<>();
        errors.put("HttpMessageNotReadableException", errorMessage);
        return new Result().error(HttpStatus.BAD_REQUEST.value(), "HttpMessageNotReadableException", errors);
    }

    // catch all other exceptions
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {Throwable.class})
    public Result handleException(Throwable e) {
        String errorMessage = e.getMessage();
        Map<String, String> errors = new HashMap<>();
        errors.put("Exception", errorMessage);

        return new Result().error(HttpStatus.BAD_REQUEST.value(), "Exception", errors);
    }
}
