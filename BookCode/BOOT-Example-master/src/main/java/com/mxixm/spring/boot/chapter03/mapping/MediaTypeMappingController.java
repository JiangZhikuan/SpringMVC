package com.mxixm.spring.boot.chapter03.mapping;

import com.mxixm.spring.boot.chapter03.entity.MyData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.annotation.XmlRootElement;

@Controller
public class MediaTypeMappingController {

    // 接受json类型的请求
    @RequestMapping(path = "myConsumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String applicationJsonValue() {
        return "myFormAgreedView";
    }

    // 接受xml类型的请求
    @RequestMapping(path = "myConsumes", consumes = MediaType.APPLICATION_XML_VALUE)
    public String applicationXmlValue() {
        return "myFormNotAgreeView";
    }

    // Accept为application/json的处理器，用于产生JSON类型的返回值
    @RequestMapping(path = "myProduces", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody // 使用@ResponseBody标记方法，声明返回值使用HttpMessageConverter转换，而不使用视图解析。在后面详解
    public MyData returnJsonValue() {
        return getMyData();
    }

    // Accept为application/xml的处理器，用于产生XML类型的返回值
    @RequestMapping(path = "myProduces", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public MyData returnXmlValue() {
        return getMyData();
    }

    // 测试Accept为*/*，通过produces指定返回值类型为json
    @RequestMapping(path = "myAcceptAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MyData acceptAll() {
        return getMyData();
    }

    // 获取测试数据
    private MyData getMyData() {
        MyData myData = new MyData();
        myData.setFirstName("Guang");
        myData.setLastName("shan");
        return myData;
    }

}
