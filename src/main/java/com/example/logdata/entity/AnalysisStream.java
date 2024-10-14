package com.example.logdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "analysis_stream")
@Data
public class AnalysisStream {
    @Id
    private Integer asid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Integer input_nums;
    @Column(nullable = false)
    private Integer output_nums;
    @Column(nullable = false)
    private Boolean duration; // 是否为持续型分析流
}
