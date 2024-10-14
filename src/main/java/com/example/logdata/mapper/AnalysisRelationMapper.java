package com.example.logdata.mapper;

import com.example.logdata.entity.AnalysisRelation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnalysisRelationMapper {
    // 获取每个分析流的分析元
    @Select("select * from analysis_relation where asid=#{asid}")
    List<AnalysisRelation> selectRelationByAsid(Integer asid);
    @Delete("delete from analysis_relation where asid=#{asid}")
    int deleteRelationByAid(Integer asid);
}
