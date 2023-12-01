package com.javaspringboot.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.javaspringboot.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

     @Autowired
     private CourseJdbcRepository repository;

     @Override
     public void run(String... args) throws Exception {

          System.out.println("CommandLineRunner is executing...");
          repository.insert(new Course(1, "learn springboot", "Elodie"));
          repository.insert(new Course(2, "learn AWS", "Elodie"));
          repository.insert(new Course(3, "learn Java", "Elodie"));
     }

}
