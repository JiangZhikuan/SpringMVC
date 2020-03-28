package com.mxixm.spring.boot.chapter08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.theme.SessionThemeResolver;

//@Configuration
public class ThemeConfig {

    @Bean
    public ThemeResolver themeResolver() {
        return new SessionThemeResolver();
    }

}
