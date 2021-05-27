package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.LietouResumeUploadLog;
import com.example.demo.mapper.LietouResumeUploadLogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    private final static Logger logger = LoggerFactory.getLogger(SampleTest.class);

    @Autowired
    private LietouResumeUploadLogMapper lietouResumeUploadLogMapper;

    @Test
    public void testSelect() {
        List<LietouResumeUploadLog> lietouResumeUploadLogs = lietouResumeUploadLogMapper.selectList(null);
        lietouResumeUploadLogs.forEach(System.out::println);

        logger.info("------------------------------------------------------");
        QueryWrapper<LietouResumeUploadLog> wrapper1 = new QueryWrapper();
        wrapper1.lambda().eq(LietouResumeUploadLog::getLietouCompanyId, 38);
        List<LietouResumeUploadLog> lietouResumeUploadLogs1 = lietouResumeUploadLogMapper.selectList(wrapper1);
        lietouResumeUploadLogs1.forEach(System.out::println);

        logger.info("------------------------------------------------------");
        List<LietouResumeUploadLog> lietouResumeUploadLogs2 = lietouResumeUploadLogMapper.selectList(Wrappers.<LietouResumeUploadLog>lambdaQuery()
                                                        .eq(LietouResumeUploadLog::getLietouCompanyId, 38));
        lietouResumeUploadLogs2.forEach(System.out::println);

        logger.info("------------------------------------------------------");
        List<LietouResumeUploadLog> lietouResumeUploadLogs3 = lietouResumeUploadLogMapper.selectByLietouCompanyId(38);
        lietouResumeUploadLogs3.forEach(System.out::println);

    }

}