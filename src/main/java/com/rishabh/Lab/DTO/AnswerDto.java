package com.rishabh.Lab.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    private String answer;

    private Integer answerId;

    private Integer questionId;

    StringBuffer str = new StringBuffer();

}
