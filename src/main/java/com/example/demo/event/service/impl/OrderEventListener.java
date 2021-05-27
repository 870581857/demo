package com.example.demo.event.service.impl;

import com.example.demo.event.entity.OrderDTO;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 */
@Component
public class OrderEventListener implements SmartApplicationListener {

    /**
     * 支持的事件类型
     *
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == OrderStatusMsgEvent.class;
    }

    /**
     * 事件发生的目标类
     *
     * @param sourceType 事件发生的目标类类型
     * @return
     */
    @Override
    public boolean supportsSourceType(@Nullable Class<?> sourceType) {
        return true;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // 获取注册用户信息
        OrderStatusMsgEvent orderStatusMsgEvent = (OrderStatusMsgEvent) applicationEvent;
        OrderDTO orderInfo = orderStatusMsgEvent.getOrderDTO();

        // 模拟kafka发送
        // kafkaProducer.sendMsg(orderInfo);
        System.out.println("======kafka发送成功====");
    }
}
