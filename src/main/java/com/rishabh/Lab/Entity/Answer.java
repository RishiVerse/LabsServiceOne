package com.rishabh.Lab.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
@Entity
public class Answer {

    @Column(name = "answer_text", nullable = false)
    private String answer;
    @Id
    @Column(name = "answer_id", nullable = false)
    private Integer answerId;
    @Column(name = "question_id", nullable = false)
    private Integer questionId;
}
