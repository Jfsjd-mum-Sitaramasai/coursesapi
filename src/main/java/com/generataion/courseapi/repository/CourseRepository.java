package com.generataion.courseapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.generataion.courseapi.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    
}
