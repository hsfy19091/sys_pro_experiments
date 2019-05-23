package com.hsfy.experiments.experiments.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class HomeworkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String solution;
    @ManyToOne(fetch = FetchType.LAZY)
    private User student;
    @ManyToOne(fetch = FetchType.EAGER)
    private Homework homework;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            updatable = false, insertable = false)
    private LocalDateTime completeTime;
}