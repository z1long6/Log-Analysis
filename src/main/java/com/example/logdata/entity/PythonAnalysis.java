package com.example.logdata.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PythonAnalysis extends Analysis {
    private String python_file;
    private String env;
}
