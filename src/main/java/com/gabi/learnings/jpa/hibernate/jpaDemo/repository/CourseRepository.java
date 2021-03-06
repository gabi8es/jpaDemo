package com.gabi.learnings.jpa.hibernate.jpaDemo.repository;


import com.gabi.learnings.jpa.hibernate.jpaDemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;

    public CourseRepository() {
    }

    public Course findByID(Long id){
        return em.find(Course.class,id);
    }

    public Course save(Course course){
        if (course.getId() == null){
            em.persist(course);
        }
        else{
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findByID(id);
        em.remove(course);
    }

    public List find_all(){
        List resultList = em.createQuery("Select c From Course c").getResultList();
        return resultList;
    }


}
