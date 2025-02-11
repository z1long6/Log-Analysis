package com.example.logdata.mapper;

import com.example.logdata.entity.AnalysisStream;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnalysisStreamMapper {
    @Select("select * from analysis_stream")
    List<AnalysisStream> findAll();
    @Insert("insert into analysis_stream (status, name, description, duration) values ('init', #{name}, #{description}, false)")
    int addAnalysisStream(String name, String description);
    @Select("select * from analysis_stream where asid = #{asid}")
    AnalysisStream findAnalysisStreamById(Integer asid);
    @Update("update analysis_stream set name=#{name} where asid=#{asid}")
    int updateAnalysisStreamName(int asid, String name);
    @Update("update analysis_strean set description=#{description} where asid=#{asid}")
    int updateAnalysisStreamDescription(int asid, String description);
    @Delete("delete from analysis_stream where asid=#{asid}")
    int deleteAnalysisStreamById(Integer asid);
}
