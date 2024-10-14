package com.example.logdata.mapper;

import com.example.logdata.entity.Analysis;
import com.example.logdata.entity.PythonAnalysis;
import com.example.logdata.entity.ReadAnalysis;
import com.example.logdata.entity.WriteAnalysis;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnalysisMapper {
    @Select("select type from analysis where aid=#{aid}")
    String selectByPrimaryKey(Integer aid);
    @Select("select * from analysis where aid=#{aid}")
    ReadAnalysis selectReadByPrimaryKey(Integer aid);
    @Select("select * from analysis where aid=#{aid}")
    WriteAnalysis selectWriteByPrimaryKey(Integer aid);
    @Select("select * from analysis where aid=#{aid}")
    PythonAnalysis selectPythonAnalysisByPrimaryKey(Integer aid);
    @Delete("delete from analysis where aid=#{aid}")
    int deleteByPrimaryKey(Integer aid);
}
