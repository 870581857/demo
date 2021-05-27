package com.example.demo.event.service.impl;

import com.example.demo.event.entity.OrderDTO;
import org.springframework.context.ApplicationEvent;

/**
 * 事件
 */
public class OrderStatusMsgEvent extends ApplicationEvent {
    
    private OrderDTO orderDTO;

    /**
     * 重写构造函数
     *
     * @param source   发生事件的对象
     * @param orderDTO 注册用户对象
     */
    public OrderStatusMsgEvent(Object source, OrderDTO orderDTO) {
        super(source);
        this.orderDTO = orderDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}

