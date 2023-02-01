package com.generataion.courseapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generataion.courseapi.controller.dto.CourseDto;
import com.generataion.courseapi.model.Course;
import com.generataion.courseapi.service.CourseService;

@RestController
public class CoursesController {

    @Autowired 
    private CourseService courseservice;
    public CoursesController(CourseService courseservice) {
        this.courseservice= courseservice;
    }


    @CrossOrigin
    @PostMapping("/createcourse")
    public ResponseEntity<Course> createCourse(@RequestBody CourseDto courseDto){
        Course status = courseservice.createCourse(new Course(courseDto));
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
   

    @CrossOrigin
    @GetMapping("/course/{id}")

    public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
        Course status = courseservice.getCourseById(id);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/getallcourses")
    public ResponseEntity<Iterable<Course>> getAllCourses(){
        Iterable<Course> status = courseservice.getAllCourses();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id,@RequestBody Course course){
        Course status = courseservice.updateCourseById(id,course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @DeleteMapping("/coursetodelete/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Integer id){
        Course status = courseservice.deleteCourseById(id);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
}
