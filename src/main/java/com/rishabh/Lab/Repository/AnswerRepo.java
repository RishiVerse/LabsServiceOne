package com.rishabh.Lab.Repository;

import com.rishabh.Lab.Entity.Answer;
import com.rishabh.Lab.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer,Integer> {
}
