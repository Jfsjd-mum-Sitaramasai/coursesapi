package com.generataion.courseapi.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generataion.courseapi.model.Course;
import com.generataion.courseapi.repository.CourseRepository;
@Service
public class CourseServiceimpl implements CourseService{
    @Autowired
    private CourseRepository courserepository;

    public CourseServiceimpl(CourseRepository courserepository) {
      this.courserepository = courserepository;
  }

   
    public Course createCourse(Course course){
       return courserepository.save(course);
      
    }
    public Course getCourseById(Integer id){
        Optional<Course> findById=courserepository.findById(id);
        if(findById.isPresent()){
            return findById.get();
        }
    
        return null;
    }
    public Iterable<Course> getAllCourses(){
        return courserepository.findAll();
        
    }
    public Course updateCourseById(Integer id, Course course){
        Optional<Course> courseToUpdateOptional=courserepository.findById(id);
        if (!courseToUpdateOptional.isPresent()) {
            return null;
          }
         
          
          Course courseToUpdate = courseToUpdateOptional.get();
         
          if (course.getName() != null) {
            courseToUpdate.setName(course.getName());
          }
          if (course.getDescription() != null) {
            courseToUpdate.setDescription(course.getDescription());
          }
          if (course.getPrice() != null) {
            courseToUpdate.setPrice(course.getPrice());
          }
         
          Course updatedCourse = courserepository.save(courseToUpdate);
          return updatedCourse;
        }
        public Course deleteCourseById(Integer id) {
            Optional<Course> courseToDeleteOptional = courserepository.findById(id);
            if (!courseToDeleteOptional.isPresent()) {
              return null;
            }
            Course courseToDelete = courseToDeleteOptional.get();
            courserepository.delete(courseToDelete);
            return courseToDelete;
          }
       


    
}
