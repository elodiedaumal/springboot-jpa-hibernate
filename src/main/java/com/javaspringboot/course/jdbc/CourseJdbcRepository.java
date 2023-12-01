package com.javaspringboot.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

     @Autowired
     private JdbcTemplate springJdbcTemplate;

     private static String INSERT_QUERY =

               """
                         insert into course (id, name, author)
                         values(1,'Learn AWS','Elodie');
                         """;

     public void insert() {
          try {
               springJdbcTemplate.update(INSERT_QUERY);
               System.out.println("Data inserted successfully");
          } catch (Exception e) {
               e.printStackTrace();
               System.out.println("Error inserting data: " + e.getMessage());
          }
     }
}
