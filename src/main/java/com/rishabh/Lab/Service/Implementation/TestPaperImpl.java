package com.rishabh.Lab.Service.Implementation;

import com.rishabh.Lab.DTO.AnswerDto;
import com.rishabh.Lab.DTO.QuestionDto;
import com.rishabh.Lab.Entity.Answer;
import com.rishabh.Lab.Entity.Question;
import com.rishabh.Lab.Repository.AnswerRepo;
import com.rishabh.Lab.Repository.QuestionRepo;
import com.rishabh.Lab.Service.Interfaces.TestPaperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestPaperImpl implements TestPaperService {

    @Autowired
    private QuestionRepo questionRepository;

    @Autowired
    private AnswerRepo answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = modelMapper.map(questionDto, Question.class);
        question = questionRepository.save(question);
        return modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto getQuestionById(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        return modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public QuestionDto updateQuestion(Integer id, QuestionDto questionDto) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        question = modelMapper.map(questionDto, Question.class);
        question = questionRepository.save(question);
        return modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        Answer answer = modelMapper.map(answerDto, Answer.class);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDto.class);
    }

    @Override
    public List<AnswerDto> getAllAnswers() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream()
                .map(answer -> modelMapper.map(answer, AnswerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto getAnswerById(Integer id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));
        return modelMapper.map(answer, AnswerDto.class);
    }

    @Override
    public AnswerDto updateAnswer(Integer id, AnswerDto answerDto) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));
        answer = modelMapper.map(answerDto, Answer.class);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDto.class);
    }

    @Override
    public void deleteAnswer(Integer id) {
        answerRepository.deleteById(id);
    }
}