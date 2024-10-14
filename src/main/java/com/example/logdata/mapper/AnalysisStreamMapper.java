package com.example.logdata.mapper;

import com.example.logdata.entity.AnalysisStream;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnalysisStreamMapper {
    @Select("select * from analysis_stream")
    List<AnalysisStream> findAll();
    @Insert("insert into analysis_stream (status, name, description, duration) values ('init', #{name}, #{description}, false)")
    int addAnalysisStream(String name, String description);
    @Select("select * from analysis_stream where asid = #{asid}")
    AnalysisStream findAnalysisStreamById(Integer asid);
}
