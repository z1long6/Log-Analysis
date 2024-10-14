package com.example.logdata.service.serviceImpl;

import com.example.logdata.entity.*;
import com.example.logdata.mapper.AnalysisRelationMapper;
import com.example.logdata.mapper.AnalysisStreamMapper;
import com.example.logdata.service.AnalysisStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalysisStreamServiceImpl implements AnalysisStreamService {
    @Autowired
    AnalysisStreamMapper analysisStreamMapper;
    @Autowired
    AnalysisTable analysisTable;
    @Autowired
    AnalysisRelationMapper analysisRelationMapper;
    @Autowired
    AnalysisServiceImpl analysisServiceImpl;

    // 根据asid查询分析表中的某个分析流
    public AnalysisStreamDTO findAnalysisStreamDTOByAsid(Integer asid){
        for (AnalysisStreamDTO analysisStreamDTO : analysisTable.getAnalysisStreamList()) {
            if (analysisStreamDTO.getAsid().equals(asid)) {
                return analysisStreamDTO;
            }
        }
        // asid不存在
        return null;
    }

    @Override
    public AnalysisTable createAnalysisTable() {
        List<AnalysisStream>analysisStreamList = analysisStreamMapper.findAll();
        // 创建AnalysisStreamDTO
        List<AnalysisStreamDTO>analysisStreamDTOList = new ArrayList<>();

        for (AnalysisStream analysisStream : analysisStreamList) {
            AnalysisStreamDTO analysisStreamDTO = new AnalysisStreamDTO();
            analysisStreamDTOList.add(analysisStreamDTO.toDTO(analysisStream));
        }

        analysisTable.setAnalysisStreamList(analysisStreamDTOList);
        return analysisTable;
    }

    @Override
    public AnalysisStreamDTO createAnalysisStreamStruct(Integer asid) {
        // 在analysisTable中根据asid查询分析流
        AnalysisStreamDTO analysisStreamDTO = findAnalysisStreamDTOByAsid(asid);
        // 为该分析流获取分析元
        List<AnalysisRelation>analysisRelationList = analysisRelationMapper.selectRelationByAsid(asid);

        for (AnalysisRelation analysisRelation : analysisRelationList) {
            AnalysisDTO analysisDTO = new AnalysisDTO();
            // 检索分析元
            analysisDTO.setAnalysis(analysisServiceImpl.getAnalysisById(analysisRelation.getAid()));
            analysisDTO.setPre_analysis(analysisServiceImpl.getAnalysisById(analysisRelation.getPre_aid()));
            analysisDTO.setNext_analysis(analysisServiceImpl.getAnalysisById(analysisRelation.getNext_aid()));

            analysisStreamDTO.getAnalysis_list().add(analysisDTO);
        }

        analysisTable.getAnalysisStreamList().remove(findAnalysisStreamDTOByAsid(asid));
        analysisTable.getAnalysisStreamList().add(analysisStreamDTO);

        return analysisStreamDTO;
    }

    @Override
    public AnalysisStream addAnalysisStream(String name, String description){
        // 持久化
        int asid = analysisStreamMapper.addAnalysisStream(name, description);
        if (asid > 0){
            // 写入分析表
            AnalysisStream analysisStream = analysisStreamMapper.findAnalysisStreamById(asid);
            AnalysisStreamDTO analysisStreamDTO = new AnalysisStreamDTO();
            analysisTable.getAnalysisStreamList().add(analysisStreamDTO.toDTO(analysisStream));
            return analysisStream;
        }else
            // 插入失败
            return null;
    }

    @Override
    public int deleteAnalysisStream(Integer asid) {
        // 判断分析流状态

        // 删除分析流

        // 删除该分析流保存的分析元结构

        // 删除分析流下的分析元

        return 0;
    }

}
