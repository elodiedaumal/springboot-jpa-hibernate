package com.javaspringboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaspringboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

     @Autowired
     private JdbcTemplate springJdbcTemplate;

     private static String INSERT_QUERY =

               """
                         insert into course (id, name, author) values(?,?,?);
                         """;

     private static String DELETE_QUERY =

               """
                         delete from course where id = ?;
                         """;

     private static String SELECT_QUERY =

               """
                         select * from course
                         where id = ?;
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

     public void deleteById(long id) {
          try {
               springJdbcTemplate.update(DELETE_QUERY, id);
               System.out.println("Data deleted successfully");
          } catch (Exception e) {
               e.printStackTrace();
               System.out.println("Error deleting data: " + e.getMessage());
          }
     }

     public Course findById(long id) {

          System.out.println("Data showed successfully");
          return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);

     }
}
