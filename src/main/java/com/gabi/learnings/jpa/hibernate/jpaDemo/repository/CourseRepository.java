package com.gabi.learnings.jpa.hibernate.jpaDemo.repository;


import com.gabi.learnings.jpa.hibernate.jpaDemo.entity.Course;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {
    @Autowired
    EntityManager em;

    public CourseRepository() {
    }

    public Course findByID(Long id){
        return em.find(Course.class,id);
    }
/*
    public Course save(Course course);
    public void deleteById(Long id);
*/

}
