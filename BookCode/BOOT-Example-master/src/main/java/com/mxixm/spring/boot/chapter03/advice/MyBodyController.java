package com.mxixm.spring.boot.chapter03.advice;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyBodyController {

    @PostMapping("/myDataRequestAdvice")
    @ResponseBody
    public String myDataRequestAdvice(@RequestBody MyData myData) {
        System.out.println(myData);
        return myData.toString();
    }

    @GetMapping("/myDataResponseAdvice")
    @ResponseBody
    public MyData myDataResponseAdvice() {
        MyData myData = new MyData();
        myData.setFirstName("Guang");
        myData.setLastName("shan");
        return myData;
    }

}
