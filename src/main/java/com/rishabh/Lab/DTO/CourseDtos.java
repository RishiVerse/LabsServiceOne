//package com.rishabh.Lab.DTO;
//
//import com.rishabh.Lab.Entity.Lesson;
//import com.rishabh.Lab.Entity.User;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.sql.Timestamp;
//import java.util.Set;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class CourseDto {
//
//    @Override
//    public String toString() {
//        return "CourseDto{" +
//                "courseId=" + courseId +
//                ", courseName='" + courseName + '\'' +
//                ", instructorUsername=" + instructorUsername +
//                ", description='" + description + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                ", lesson=" + lesson +
//                '}';
//    }
//
//    private Integer courseId;
//    private String courseName;
//    private User instructorUsername;
//    private String description;
//    private Timestamp createdAt;
//    private Timestamp updatedAt;
//    private Set<Lesson> lesson;
//
//    public static class CourseBuilder {
//        private Integer courseId;
//        private String courseName;
//        private User instructorUsername;
//        private String description;
//        private Timestamp createdAt;
//        private Timestamp updatedAt;
//        private Set<Lesson> lesson;
//
//        public CourseBuilder setCourseId(Integer courseId) {
//            this.courseId = courseId;
//            return this;
//        }
//
//        public CourseBuilder setCourseName(String courseName) {
//            this.courseName = courseName;
//            return this;
//        }
//
//        public CourseBuilder setInstructorUsername(User instructorUsername) {
//            this.instructorUsername = instructorUsername;
//            return this;
//        }
//
//        public CourseBuilder setDescription(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public CourseBuilder setCreatedAt(Timestamp createdAt) {
//            this.createdAt = createdAt;
//            return this;
//        }
//
//        public CourseBuilder setUpdatedAt(Timestamp updatedAt) {
//            this.updatedAt = updatedAt;
//            return this;
//        }
//
//        public CourseBuilder setLesson(Set<Lesson> lesson) {
//            this.lesson = lesson;
//            return this;
//        }
//
//        // The method to build the CourseDto object
//        public CourseDto build() {
//            return new CourseDto(courseId, courseName, instructorUsername, description, createdAt, updatedAt, lesson);
//        }
//
//        // The method to get an instance of CourseBuilder
//        public static CourseBuilder builder() {
//            return new CourseBuilder();
//        }
//    }
//}
