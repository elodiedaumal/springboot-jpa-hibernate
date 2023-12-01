package com.javaspringboot.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaspringboot.course.Course;

@Repository
public class CourseJdbcRepository {

     @Autowired
     private JdbcTemplate springJdbcTemplate;

     private static String INSERT_QUERY =

               """
                         insert into course (id, name, author) values(?,?,?);
                         """;

     public void insert(Course course) {
          try {
               springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
               System.out.println("Data inserted successfully");
          } catch (Exception e) {
               e.printStackTrace();
               System.out.println("Error inserting data: " + e.getMessage());
          }
     }
}
