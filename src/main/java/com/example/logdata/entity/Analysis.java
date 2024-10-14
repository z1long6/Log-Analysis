package com.example.logdata.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "analysis")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@Data
public class Analysis {
    @Id
    private Integer aid;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    private String inputs;
    private String outputs;
    @Column(nullable = false)
    private String debug_status;
    private String debug_input;
    private String debug_output;
    private Integer input_nums;
    private Integer output_nums;
    private Boolean visit;
}
