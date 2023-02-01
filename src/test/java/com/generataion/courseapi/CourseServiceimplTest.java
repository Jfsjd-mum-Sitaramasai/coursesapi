package com.generataion.courseapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.generataion.courseapi.model.Course;
import com.generataion.courseapi.repository.CourseRepository;
import com.generataion.courseapi.service.CourseService;
import com.generataion.courseapi.service.CourseServiceimpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestInstance( TestInstance.Lifecycle.PER_CLASS)
public class CourseServiceimplTest
{

    @Mock
    CourseRepository courseRepository;

    CourseService courseService;

    @BeforeAll
    public void setup()
    {
        courseService = new CourseServiceimpl( courseRepository );
    }

    @Test
    public void saveCallsItemsRepositorySave()
    {
        Course courseMock = mock( Course.class );
        courseService.createCourse( courseMock );
        verify( courseRepository ).save( courseMock );
    }
    @Test
    public void getCallsItemsRepositoryget()
    {
        
        courseService.getAllCourses( );
        verify( courseRepository ).findAll();
    }
}


