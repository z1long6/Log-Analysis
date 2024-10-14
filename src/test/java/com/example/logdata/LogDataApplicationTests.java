package com.example.logdata;

import com.example.logdata.entity.AnalysisTable;
import com.example.logdata.mapper.AnalysisMapper;
import com.example.logdata.service.serviceImpl.AnalysisStreamServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LogDataApplicationTests {
    @Autowired
    AnalysisStreamServiceImpl analysisStreamService;
    @Autowired
    AnalysisMapper analysisMapper;
    @Autowired
    AnalysisTable analysisTable;

    @BeforeEach
    void myTest() {
        // 程序启动创建分析表
        analysisStreamService.createAnalysisTable();
    }

    @Test
    void myTest2() {
        analysisStreamService.addAnalysisStream("test1",  "test2");
    }

}
