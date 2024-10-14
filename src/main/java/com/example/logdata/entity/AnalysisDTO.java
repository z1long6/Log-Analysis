package com.example.logdata.entity;

import lombok.Data;

@Data
public class AnalysisDTO {
    private Analysis analysis;
    private Analysis pre_analysis;
    private Analysis next_analysis;
}
