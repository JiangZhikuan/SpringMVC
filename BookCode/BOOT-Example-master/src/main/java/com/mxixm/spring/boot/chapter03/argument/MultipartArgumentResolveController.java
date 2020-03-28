package com.mxixm.spring.boot.chapter03.argument;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MultipartArgumentResolveController {

    @RequestMapping("multipartForm")
    public String multipartForm() {
        return "myMultipartFormView";
    }

    @RequestMapping("multipartFormSubmit")
    public String multipartFormSubmit(@RequestPart int firstName, @RequestPart String lastName, @RequestPart MultipartFile photo) {
        return "myFormAgreedView";
    }

}
