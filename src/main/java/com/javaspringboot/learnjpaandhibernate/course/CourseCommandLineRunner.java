package com.javaspringboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.javaspringboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.javaspringboot.learnjpaandhibernate.course.jpa.CourseJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

     // @Autowired
     // private CourseJdbcRepository repository;

     @Autowired
     private CourseJPARepository repository;

     @Override
     public void run(String... args) throws Exception {

          repository.insert(new Course(1, "learn springboot", "Elodie"));
          repository.insert(new Course(2, "learn AWS", "Elodie"));
          repository.insert(new Course(3, "learn Java", "Elodie"));

          repository.deleteById(1);

          System.out.println(repository.findById(2));
          System.out.println(repository.findById(3));

     }

}
