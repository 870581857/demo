package com.example.demo;

import com.example.demo.event.entity.OrderDTO;
import com.example.demo.event.service.impl.OrderStatusMsgEvent;
import com.example.demo.event.service.impl.SpringEventPublishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTest {
    @Autowired
    SpringEventPublishService eventPublishService;

    @Test
    public void pushEventTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(1l);
        orderDTO.setOrderStatus(1);
        orderDTO.setSpuId(UUID.randomUUID().toString());
        orderDTO.setCreateTime(new Date());
        orderDTO.setUpdateTime(new Date());
        OrderStatusMsgEvent orderStatusMsgEvent = new OrderStatusMsgEvent(OrderDTO.class,orderDTO);
        eventPublishService.publishEvent(orderStatusMsgEvent);
        System.out.println("时间发布成功");
    }


}
