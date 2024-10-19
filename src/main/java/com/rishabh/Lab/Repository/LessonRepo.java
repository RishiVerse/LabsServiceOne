package com.rishabh.Lab.Repository;

import com.rishabh.Lab.Entity.Lesson;
import com.rishabh.Lab.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson,Integer> {
}
