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
public class CourseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY)
    private User student;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
}