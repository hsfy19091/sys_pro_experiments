package com.hsfy.experiments.experiments.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private User teacher;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
}
