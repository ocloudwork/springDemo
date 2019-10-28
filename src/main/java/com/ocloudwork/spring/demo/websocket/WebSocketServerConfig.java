package com.ocloudwork.spring.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.SockJsServiceRegistration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketServerConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 添加拦截地址以及相应的websocket消息处理器
        WebSocketHandlerRegistration registration = registry.addHandler(new MyWebSocketHandler(), "/websocket","sockjs/websocket");
        SockJsServiceRegistration sockJS = registration.withSockJS();
        // 添加拦截器
        registration.addInterceptors(new MyHandshakeInterceptor());
    }

}