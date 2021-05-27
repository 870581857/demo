package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LietouResumeUploadLog {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 简历名称
     */
    private String fileName;

    /**
     * 简历id
     */
    private String commonResumeId;

    /**
     * 上传人id
     */
    private Integer userId;

    /**
     * 上传人姓名
     */
    private String userName;

    /**
     * 上传人所属猎头企业
     */
    private Integer lietouCompanyId;

    /**
     * 是否完善：1-未完善，2-已完善
     */
    private Integer isPerfect;

    /**
     * 上传来源：1-顾问上传，2-负责人上传
     */
    private Integer source;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除标识：0-未删除，1-删除 
     */
    private Integer isDel;
}