package com.example.demo.event.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {
    private long orderId;
    private String spuId;
    private int orderStatus;
    private Date createTime;
    private Date updateTime;
}