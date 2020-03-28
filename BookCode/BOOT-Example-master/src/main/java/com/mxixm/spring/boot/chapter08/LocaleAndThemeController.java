package com.mxixm.spring.boot.chapter08;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
public class LocaleAndThemeController {

    @GetMapping("locale")
    public String locale() {
        return "localeView";
    }

    @GetMapping("theme")
    public String theme() {
        return "themeView";
    }

    @GetMapping("changeTheme")
    public String changeTheme(HttpServletRequest request, HttpServletResponse response) {
        // 通过请求上下文工具类获取主题解析器，并设置主题名，注意原始的固定主题解析器不支持设置主题
        RequestContextUtils.getThemeResolver(request).setThemeName(request, response, "other");
        return "themeView";
    }

    private void localeDebug() {
        Locale locale = new Locale.Builder().setLanguage("zh").setScript("Hans").setRegion("CN").setVariant("Beijing_Shanghai").build();
        ResourceBundle.Control control = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
        control.getCandidateLocales("abc", locale);
    }

}
