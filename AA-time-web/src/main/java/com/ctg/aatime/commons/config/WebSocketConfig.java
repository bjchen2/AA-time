package com.ctg.aatime.commons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.AbstractMessageBrokerConfiguration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;

/**
 * websocket 配置类
 *
 * @author pjmike
 * @create 2018-03-24 11:57
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends WebSocketMessageBrokerConfigurationSupport{
    /**
     * 首先要连接stomp端点
     *
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册一个STOMP的endpoint端点，并指定使用SockJS协议,前端通过这个端点与服务器建立websocket连接
        stompEndpointRegistry.addEndpoint("/endpoint").withSockJS();
    }

    /**
     * MessageBrokerRegistry,配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        super.configureMessageBroker(registry);
        //设置目的地前缀
        registry.enableSimpleBroker("/topic", "/queue");
        //设置应用程序前缀，前端发起的请求会自动添加/app
        registry.setApplicationDestinationPrefixes("/app");
    }
}
