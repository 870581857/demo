package com.example.demo.event.service;

import org.springframework.stereotype.Component;

// 抽象事件发布
public interface EventPublishService<T> {
    void publishEvent(T event);
}


