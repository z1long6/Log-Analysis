package com.example.logdata.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class AnalysisStreamDTO extends AnalysisStream{
    // 分析流任务上下文
    private Map<String, String> task_map = new HashMap<>();
    // 当前分析流包含的分析元列表
    private List<AnalysisDTO>analysis_list = new ArrayList<>();

    // 转换成DTO对象
    public AnalysisStreamDTO toDTO(AnalysisStream analysisStream){
        AnalysisStreamDTO analysisStreamDTO = new AnalysisStreamDTO();

        analysisStreamDTO.setAsid(analysisStream.getAsid());
        analysisStreamDTO.setName(analysisStream.getName());
        analysisStreamDTO.setDescription(analysisStream.getDescription());
        analysisStreamDTO.setDuration(analysisStream.getDuration());
        analysisStreamDTO.setStatus(analysisStream.getStatus());
        analysisStreamDTO.setInput_nums(analysisStream.getInput_nums());
        analysisStreamDTO.setOutput_nums(analysisStream.getOutput_nums());

        return analysisStreamDTO;
    }

}
