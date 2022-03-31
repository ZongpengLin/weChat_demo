package com.example.demo.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice   //需要与前端交互 所以使用@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)    // 所有exception 的父类
    @ResponseBody
    //请求参数和异常两个入参
    private Map<String,Object> exceptionHandler(HttpServletRequest req, Exception e){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }
}
