package com.ocloudwork.spring.demo.websocket;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyWebSocketHandler implements WebSocketHandler {

    //保存用户链接
    private static ConcurrentHashMap<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
  // 连接 就绪时
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        users.put(session.getId(), session);
    }

    // 处理信息
    @Override
    public void handleMessage(WebSocketSession session,
            WebSocketMessage<?> message) throws Exception {
        System.err.println(session + "---->" + message + ":"+ message.getPayload().toString());
    }

    // 处理传输时异常
    @Override
    public void handleTransportError(WebSocketSession session,
            Throwable exception) throws Exception {

    }

    // 关闭 连接时
    @Override
    public void afterConnectionClosed(WebSocketSession session,
            CloseStatus closeStatus) {
    	System.err.println("用户： " + session.getRemoteAddress() + " is leaving, because:" + closeStatus);
    }

    //是否支持分包
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
