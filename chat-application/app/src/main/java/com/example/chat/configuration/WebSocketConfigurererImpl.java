package com.example.chat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.chat.websocket.WebSocketEventListenerManager;
import com.example.chat.websocket.WebSocketHandlerImpl;

@Configuration
@EnableWebSocket
public class WebSocketConfigurererImpl implements WebSocketConfigurer {

    private final WebSocketHandlerImpl webSocketHandler;

    public WebSocketConfigurererImpl() {
        this.webSocketHandler = new WebSocketHandlerImpl();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getWebSocketHandler(), "/chat").setAllowedOrigins("*");
    }

    @Bean
    WebSocketHandler getWebSocketHandler() {
        return this.webSocketHandler;
    }

    @Bean
    WebSocketEventListenerManager getWebSocketEventListenerManager() {
        return this.webSocketHandler;
    }

}
