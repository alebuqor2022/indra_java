package com.indra.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.SpringBootDemo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
