package com.example.logdata.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WriteAnalysis extends Analysis{
    private String index_id;
}
