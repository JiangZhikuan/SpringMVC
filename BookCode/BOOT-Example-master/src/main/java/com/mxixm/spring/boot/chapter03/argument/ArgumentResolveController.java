package com.mxixm.spring.boot.chapter03.argument;

import com.mxixm.spring.boot.chapter03.entity.MyPostData;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class ArgumentResolveController {

    @RequestMapping("argument1")
    public String argument(HttpServletRequest request) {
        System.out.println("访问者IP为" + request.getRemoteAddr());
        return "argumentView";
    }

    @RequestMapping("user/{userId}/topic/{topicId}")
    public String topic(@PathVariable Integer userId, @PathVariable Integer topicId, @PathVariable Optional<Integer> test) {
        System.out.println("userId is " + userId + ", topicId is " + topicId);
        return "argumentView";
    }

    // 访问/users/year/66;hobbies=computer,math;year=1992
    @GetMapping("/users/year/{userId}")
    public String findUserByIdWithYear(@PathVariable String userId, @MatrixVariable int year) {
        // userId = 66, year=1992
        return "argumentView";
    }

    // pathVar属性的使用，访问 /users/66;q=11/things/21;q=22
    @GetMapping("/users/{userId}/things/{thingId}")
    public String findThingWithMatrix(
            @MatrixVariable(name = "q", pathVar = "userId") int q1,
            @MatrixVariable(name = "q", pathVar = "thingId") int q2) {
        // q1 == 11
        // q2 == 22
        return "argumentView";
    }

    // 访问 /users/66，不提供q的值
    @GetMapping("/users/{userId}")
    public String findUserByIdWithDefault(@MatrixVariable(required = false, defaultValue = "1") int q) {
        // required即使不设置，使用默认值true，效果也和设置为false一样。
        // q == 1
        return "argumentView";
    }

    // 访问 /usersMap/66;q=11;r=12/things/21;q=22;s=23
    @GetMapping("/usersMap/{userId}/things/{thingId}")
    public String findThingWithMatrixMap(
            @MatrixVariable MultiValueMap<String, String> matrixVars,
            @MatrixVariable(pathVar = "thingId") MultiValueMap<String, String> thingMatrixVars) {
        // 两个MultiValueMap合并的结果
        // matrixVars: ["q" : [11, 22], "r" : 12, "s" : 23]
        // thingMatrixVars: ["q" : 22, "s" : 23]
        // 参数也可以声明为Map类型，但是当一个矩阵变量对应多个值时，只会取第一个值，后面的值会丢失
        return "argumentView";
    }

    // 访问 /users?userId=66
    @GetMapping("/users")
    public String findUserById(String userId) {
        // userId=66
        return "argumentView";
    }

    // 访问 /findUser?firstName=Guang&lastName=shan&lastName=666
    @GetMapping("/findUser")
    public String findUserByName(@RequestParam MultiValueMap<String, String> params) {
        // params: ["firstName" : "Guang", "lastName": ["shan", "666"]]
        System.out.println(params);
        return "argumentView";
    }

    // 请求头为Accept: text/html,application/xhtml+xml,application/xml;q=0.9
    @GetMapping("/getAccept")
    public String getAccept(@RequestHeader List<String> accept) {
        // accept: ["text/html", "application/xhtml+xml", "application/xml;q=0.9"]
        System.out.println(accept);
        return "argumentView";
    }

    // 请求包含如下Cookie：JSESSIONID=415A4AC178C59DACE0B2C9CA727CDD84
    @GetMapping("/getCookie")
    public String getCookie(@CookieValue("JSESSIONID") String jSessionId) {
        // jSessionId: "415A4AC178C59DACE0B2C9CA727CDD84"
        System.out.println(jSessionId);
        return "argumentView";
    }

    @PostMapping("/postData")
    // 标记@Validated以进行数据校验，第二个参数绑定校验结果
    // 校验结果取其前面与其紧邻的参数的校验结果进行绑定，所以两个参数必须紧邻
    public String postData(@Validated @RequestBody MyPostData myPostData, BindingResult result) {
        System.out.println("数据校验是否有错误：" + result.hasErrors());
        System.out.println(myPostData);
        return "argumentView";
    }

    @PostMapping("/postEntity")
    public String postEntity(HttpEntity<MyPostData> myPostData) {
        System.out.println(myPostData.getHeaders());
        System.out.println(myPostData.getBody());
        return "argumentView";
    }

    @GetMapping("/redirectAttribute")
    public String redirectAttribute(Model model) {
        return "argumentView";
    }

}
