package com.example.demo.event.service.impl;

import com.example.demo.event.service.EventPublishService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 事件发布
 */
@Component
public class SpringEventPublishService implements EventPublishService<ApplicationEvent>, ApplicationContextAware {

    private ApplicationContext applicationContext;
    
    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
