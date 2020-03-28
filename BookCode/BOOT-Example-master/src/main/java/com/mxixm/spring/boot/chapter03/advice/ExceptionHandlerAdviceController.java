package com.mxixm.spring.boot.chapter03.advice;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 定义RESTful控制器，所有处理器方法均按照@ResponseBody返回
@RestController
public class ExceptionHandlerAdviceController {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }

    @GetMapping("exceptionHandler")
    public String exceptionHandler() throws Exception {
        System.out.println("Throw Exception");
        throw new Exception("Test Exception");
    }

    // 指定响应状态码为500
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandlerStatus(Exception e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }

    @GetMapping("exceptionHandlerStatus")
    public int exceptionHandlerStatus() {
        // 抛出异常，除数不能为0，为RuntimeException的子类
        int result = 1 / 0;
        return result;
    }

    @GetMapping(path = "responseStatus")
    @ResponseStatus
    public ResponseEntity<MyData> responseStatus() {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Test", "For Test")
                .body(new MyData());
    }

}
