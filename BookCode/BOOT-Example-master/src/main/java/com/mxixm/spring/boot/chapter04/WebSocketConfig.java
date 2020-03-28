package com.mxixm.spring.boot.chapter04;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
// 通过该注解表示开启WebSocket功能
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    // 注册WebSocket的处理器，同时还添加了一个HandshakeInterceptor
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebSocketHandler(), "/myWebSocket")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

}