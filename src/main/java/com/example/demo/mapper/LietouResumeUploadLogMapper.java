package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.LietouResumeUploadLog;

import java.util.List;

public interface LietouResumeUploadLogMapper extends BaseMapper<LietouResumeUploadLog> {
    List<LietouResumeUploadLog> selectByLietouCompanyId(Integer lietouCompanyId);
}
