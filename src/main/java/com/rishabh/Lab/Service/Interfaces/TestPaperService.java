package com.rishabh.Lab.Service.Interfaces;

import com.rishabh.Lab.DTO.AnswerDto;
import com.rishabh.Lab.DTO.QuestionDto;

import java.util.List;


public interface TestPaperService {

    QuestionDto createQuestion(QuestionDto questionDto);

    List<QuestionDto> getAllQuestions();

    QuestionDto getQuestionById(Integer id);

    QuestionDto updateQuestion(Integer id, QuestionDto questionDto);

    void deleteQuestion(Integer id);

    AnswerDto createAnswer(AnswerDto answerDto);

    List<AnswerDto> getAllAnswers();

    AnswerDto getAnswerById(Integer id);

    AnswerDto updateAnswer(Integer id, AnswerDto answerDto);

    void deleteAnswer(Integer id);
}
