package com.example.logdata.service.serviceImpl;

import com.example.logdata.entity.*;
import com.example.logdata.mapper.AnalysisMapper;
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
    @Autowired
    private AnalysisMapper analysisMapper;

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

    // 判断分析流状态
    public String judgeStatus(Integer asid){

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

        // 持久化删除
        // 删除该分析流保存的分析元结构 analysis relation
        int analysis_num = analysisRelationMapper.deleteRelationByAid(asid);
        List<AnalysisDTO>list = findAnalysisStreamDTOByAsid(asid).getAnalysis_list();
        int temp_analysis_num = 0;
        for (AnalysisDTO analysisDTO : list) {
            int aid = analysisDTO.getAnalysis().getAid();
            // 删除分析流下的分析元 analysis
            temp_analysis_num += analysisMapper.deleteByPrimaryKey(aid);
        }
        // 删除分析流 analysis stream
        int delete_num = analysisStreamMapper.deleteAnalysisStreamById(asid);
        // 从分析表中删除
        analysisTable.getAnalysisStreamList().remove(findAnalysisStreamDTOByAsid(asid));

        return analysis_num + temp_analysis_num + delete_num;
    }

    @Override
    public List<Integer> updateAnalysisStream(Integer asid, String new_name, String new_description) {
        // 更新分析表
        findAnalysisStreamDTOByAsid(asid).setName(new_name);
        findAnalysisStreamDTOByAsid(asid).setDescription(new_description);
        // 更新持久化
        int a=0,b=0;
        if (!new_name.isEmpty()) {
            a = analysisStreamMapper.updateAnalysisStreamName(asid, new_name);
        }
        if (!new_description.isEmpty()) {
            b = analysisStreamMapper.updateAnalysisStreamDescription(asid, new_description);
        }
        List<Integer>temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        return temp;
    }

    @Override
    public void modifyAnalysisStream(Integer asid){
    }

    @Override
    public void runAnalysisStream(Integer asid) {
    }

    @Override
    public void pauseAnalysisStream(Integer asid) {
    }

    @Override
    public void stopAnalysisStream(Integer asid) {
    }

    @Override
    public void resetAnalysisStream(Integer asid) {
    }

    @Override
    public void getAnalysisStreamResult(AnalysisStreamDTO dto) {
    }

}
