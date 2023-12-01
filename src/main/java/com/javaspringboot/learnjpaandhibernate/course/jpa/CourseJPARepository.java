package com.javaspringboot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.javaspringboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {

     @PersistenceContext
     private EntityManager entityManager;

     public void insert(Course course) {
          entityManager.merge(course);
     }

     public void deleteById(long id) {
          Course course = entityManager.find(Course.class, id);
          entityManager.remove(course);
     }

     public Course findById(long id) {
          return entityManager.find(Course.class, id);

     }
}
