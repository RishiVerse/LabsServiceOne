package com.rishabh.Lab.Repository;

import com.rishabh.Lab.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
