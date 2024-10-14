package com.example.logdata.service;

import com.example.logdata.entity.AnalysisStream;
import com.example.logdata.entity.AnalysisStreamDTO;
import com.example.logdata.entity.AnalysisTable;

import java.util.List;

public interface AnalysisStreamService {
    /*
        初始创建分析表，获取所有分析流
     */
    AnalysisTable createAnalysisTable();
    /*
        添加分析流
        @param String name, String description
     */
    AnalysisStream addAnalysisStream(String name, String description);
    /*
        删除分析流
        @param Integer asid
     */
    int deleteAnalysisStream(Integer asid);
    /*
        打开分析流
        @param String asid
    */
    AnalysisStreamDTO createAnalysisStreamStruct(Integer asid);
    /*
        重命名分析流
        @param Integer asid, String name, String description
     */
    List<Integer> updateAnalysisStream(Integer asid, String new_name, String new_description);
    /*
        编辑分析流
     */
    void modifyAnalysisStream(Integer asid);
    /*
        运行分析流
     */
    void runAnalysisStream(Integer asid);
    /*
        暂停分析流
     */
    void pauseAnalysisStream(Integer asid);
    /*
        停止分析流
     */
    void stopAnalysisStream(Integer asid);
    /*
        重置分析流
     */
    void resetAnalysisStream(Integer asid);
    /*
        查看分析结果
     */
    void getAnalysisStreamResult(AnalysisStreamDTO dto);
}
