package com.generataion.courseapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.generataion.courseapi.controller.CoursesController;
import com.generataion.courseapi.controller.dto.CourseDto;
import com.generataion.courseapi.model.Course;
import com.generataion.courseapi.service.CourseService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
public class CourseControllerTest
{

    

    @Mock
    CourseService courseService;

    CoursesController courseController;

    @BeforeAll
    public void setup()
    {
        courseController = new CoursesController( courseService );
    }

    @Test
    public void saveCallsSaveOnCourseService()
    {
        CourseDto courseDtoMock = mock( CourseDto.class );
        courseController.createCourse( courseDtoMock );
        verify( courseService ).createCourse(any(Course.class));
    }
    @Test
    public void getItemsCallsAllOnCourseService(){
        courseController.getAllCourses();
        verify( courseService ).getAllCourses();
    }
    
    
}
