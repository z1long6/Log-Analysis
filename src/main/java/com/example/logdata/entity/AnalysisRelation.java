package com.example.logdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@IdClass(AnalysisIdClass.class)
@Table(name = "analysis_relation")
@Data
public class AnalysisRelation {
    @Id
    private Integer asid;
    @Id
    private Integer aid;

    private Integer pre_aid;
    private Integer next_aid;
}
