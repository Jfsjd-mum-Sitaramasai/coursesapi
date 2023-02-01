package com.generataion.courseapi.service;




import com.generataion.courseapi.model.Course;



public interface CourseService {
    




    public Course createCourse(Course course);
    public Course getCourseById(Integer id);
    public Iterable<Course> getAllCourses();
    public Course updateCourseById(Integer id, Course course);
    public Course deleteCourseById(Integer id);


}
