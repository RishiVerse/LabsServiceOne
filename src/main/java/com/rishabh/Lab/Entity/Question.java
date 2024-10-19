package com.rishabh.Lab.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
@Entity
public class Question {
    @Id
    @Column(name = "question_id", nullable = false)
    private Integer questionId;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(name = "question_type", nullable = false)
    private String questionType;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Answer answer;
}