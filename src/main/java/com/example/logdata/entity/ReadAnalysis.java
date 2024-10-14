package com.example.logdata.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("reader")
@Data
public class ReadAnalysis extends Analysis {
    private String index_id;
    private String seek;
    private String lucene;
    private String time_change;
}
