package com.example.logdata.entity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class AnalysisTable {
    // 在分析表中持有分析流
    private List<AnalysisStreamDTO> analysisStreamList;
    // 在分析表中持有事件列表

    public AnalysisTable (List<AnalysisStreamDTO> list){
        this.analysisStreamList = list;
    }

}
