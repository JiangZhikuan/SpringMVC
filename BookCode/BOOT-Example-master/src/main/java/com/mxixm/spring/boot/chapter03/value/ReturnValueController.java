package com.mxixm.spring.boot.chapter03.value;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ReturnValueController {

    @GetMapping(path = "myResponseBody")
    @ResponseBody
    public MyData myResponseBody() {
        return getMyData();
    }

    // 获取测试数据
    private MyData getMyData() {
        MyData myData = new MyData();
        myData.setFirstName("Guang");
        myData.setLastName("shan");
        return myData;
    }

    @GetMapping(path = "myResponseEntity")
    @ResponseBody
    public ResponseEntity<MyData> myResponseEntity() {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Test", "For Test")
                .body(getMyData());
    }

    @GetMapping(path = "myModelReturn")
    public Map<String, Object> modelReturn() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", "Guangshan");
        return map;
    }


    @GetMapping(path = "myModelAttributeReturn")
    @ModelAttribute("data")
    public MyData modelAttributeReturn() {
        return getMyData();
    }

    @GetMapping("/modelAndViewReturn")
    public ModelAndView modelAndViewReturn() {
        Map<String, Object> model = new HashMap<>(2);
        model.put("name", "返回ModelAndView");
        // 返回ModelAndView，第一个参数是视图名，第二个参数是模型，第三个参数指定返回状态码404
        return new ModelAndView("defaultView", model, HttpStatus.NOT_FOUND);
    }

}
