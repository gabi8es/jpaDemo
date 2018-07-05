package com.gabi.learnings.jpa.hibernate.jpaDemo.repository;

import com.gabi.learnings.jpa.hibernate.jpaDemo.JpaDemoApplication;
import com.gabi.learnings.jpa.hibernate.jpaDemo.entity.Course;
import com.gabi.learnings.jpa.hibernate.jpaDemo.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    public void findByID_basic(){
        Course course = repository.findByID(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }
    @Test
    public void findByID() {
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        Course courseToInsert = new Course("New course inserted");
        courseToInsert = repository.save(courseToInsert);
        assertEquals(courseToInsert.getName(), repository.findByID(courseToInsert.getId()).getName());
    }

    @Test
    @DirtiesContext
    public void save_modif() {
        Course courseToInsert = repository.findByID(10001L);
        courseToInsert.setName("Modified");
        courseToInsert = repository.save(courseToInsert);
        assertEquals(courseToInsert.getName(), repository.findByID(courseToInsert.getId()).getName());
    }

    @Test
    public void deleteById_basic() {
        repository.deleteById(10002L);
        assertNull(repository.findByID(10002L));
    }
}