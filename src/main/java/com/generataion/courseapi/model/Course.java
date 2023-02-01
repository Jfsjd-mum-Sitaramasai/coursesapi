package com.generataion.courseapi.model;



import com.generataion.courseapi.controller.dto.CourseDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="COURSES1_DETAILS")


public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="Name")
    private String name;
    @Column(name="Description")
    private String description;
    @Column(name="ImageUrl")
    private String imageurl;
    @Column(name="Price")
    private Float price;
    public Course()
    {
    }
    public Course( CourseDto courseDto )
    {
        this.name = courseDto.getName();
        this.description = courseDto.getDescription();
        this.imageurl = courseDto.getImageUrl();
        this.price= courseDto.getPrice();
    }

    @Override
    public String toString()
    {
        return "Course{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageUrl='"
            + imageurl + '\'' +", price='"+price+ '}';
    }

    
}
