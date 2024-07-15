// package com.rishabh.Lab.Service.Implementation;

// import com.rishabh.Lab.DTO.CourseDto;
// import com.rishabh.Lab.Entity.Course;
// import com.rishabh.Lab.Entity.User;
// import com.rishabh.Lab.Repository.CourseRepository;
// import com.rishabh.Lab.Repository.UserDetailRepository;
// import com.rishabh.Lab.Service.Interfaces.CourseService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.modelmapper.ModelMapper;

// import java.util.Collections;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.Mockito.*;

// @ExtendWith(MockitoExtension.class)
// public class CourseServiceImplTest {

//     @Mock
//     private CourseRepository courseRepository;

//     @Mock
//     private UserDetailRepository userDetailRepository;

//     @Mock
//     private ModelMapper modelMapper;

//     @InjectMocks
//     private CourseServiceImpl courseService;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testAddCourse_UserNotFound() {
//         CourseDto courseDto = new CourseDto();
//         courseDto.setInstructorUsername(new User("nonexistentuser"));

//         when(userDetailRepository.findByUsername("nonexistentuser")).thenReturn(Optional.empty());

//         Exception exception = assertThrows(Exception.class, () -> {
//             courseService.AddCourse(courseDto);
//         });

//         assertEquals("Username Does not Exist , Please Register yourself first than try again", exception.getMessage());
//     }

//     @Test
//     void testAddCourse_UserFound() throws Exception {
//         User instructor = new User();
//         instructor.setUsername("existinguser");
//         CourseDto courseDto = new CourseDto();
//         courseDto.setInstructorUsername(instructor);
//         courseDto.setCourseId(1L);
//         courseDto.setCourseName("Test Course");

//         when(userDetailRepository.findByUsername("existinguser")).thenReturn(Optional.of(instructor));

//         Course course = new Course(1L, "Test Course", new User(), "existinguser", null, null, new HashSet<>());
//         when(courseRepository.save(any(Course.class))).thenReturn(course);
//         when(modelMapper.map(any(Course.class), eq(CourseDto.class))).thenReturn(courseDto);

//         CourseDto result = courseService.AddCourse(courseDto);

//         assertEquals(courseDto, result);
//         verify(courseRepository, times(1)).save(any(Course.class));
//     }

//     @Test
//     void testGetCourse() {
//         Course course = new Course(1L, "Test Course", new User(), "existinguser", null, null, new HashSet<>());
//         List<Course> courses = Collections.singletonList(course);

//         when(courseRepository.findAll()).thenReturn(courses);
//         CourseDto courseDto = new CourseDto();
//         courseDto.setCourseId(1L);
//         courseDto.setCourseName("Test Course");
//         when(modelMapper.map(any(), eq(CourseDto.class))).thenReturn(courseDto);

//         CourseDto result = courseService.getCourse();

//         assertEquals(courseDto, result);
//         verify(courseRepository, times(1)).findAll();
//     }
// }
