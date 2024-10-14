package com.example.logdata.service.serviceImpl;

import com.example.logdata.entity.Analysis;
import com.example.logdata.mapper.AnalysisMapper;
import com.example.logdata.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    AnalysisMapper analysisMapper;
    @Override
    public Analysis getAnalysisById(Integer aid) {

        String type = analysisMapper.selectByPrimaryKey(aid);
        if (type == null) {
            return null;
        }
        if(type.equals("reader")){
            return analysisMapper.selectReadByPrimaryKey(aid);
        } else if (type.equals("writer")) {
            return analysisMapper.selectWriteByPrimaryKey(aid);
        } else if (type.equals("python")){
            return analysisMapper.selectPythonAnalysisByPrimaryKey(aid);
        }
        return null;
    }

}
