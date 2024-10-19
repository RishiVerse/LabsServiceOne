package com.rishabh.Lab.Controller;

import com.rishabh.Lab.DTO.AnswerDto;
import com.rishabh.Lab.DTO.QuestionDto;
import com.rishabh.Lab.Service.Interfaces.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/testpaper")
public class TestPaperController {

    @Autowired
    private TestPaperService testPaperService;

    @GetMapping
    public List<QuestionDto> getAllQuestions(){
        return testPaperService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuestionDto getQuestionById(@PathVariable Integer id){
        return testPaperService.getQuestionById(id);
    }

    @PostMapping
    public QuestionDto createQuestion(@RequestBody QuestionDto questionDto){
        return testPaperService.createQuestion(questionDto);
    }

    @PutMapping("/{id}")
    public QuestionDto updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable Integer id){
        return testPaperService.updateQuestion(id,questionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id){
        testPaperService.deleteQuestion(id);
    }

    @GetMapping("/answers")
    public List<AnswerDto> getAllAnswers(){
        return testPaperService.getAllAnswers();
    }

    @GetMapping("/answers/{id}")
    public AnswerDto getAnswerById(@PathVariable Integer id){
        return testPaperService.getAnswerById(id);
    }

    @PostMapping("/answers")
    public AnswerDto createAnswer(@RequestBody AnswerDto answerDto){
        return testPaperService.createAnswer(answerDto);
    }

    @PutMapping("/answers/{id}")
    public AnswerDto updateAnswer(@RequestBody AnswerDto answerDto, @PathVariable Integer id){
        return testPaperService.updateAnswer(id,answerDto);
    }

    @DeleteMapping("/answers/{id}")
    public void deleteAnswer(@PathVariable Integer id){
        testPaperService.deleteAnswer(id);
    }

}
