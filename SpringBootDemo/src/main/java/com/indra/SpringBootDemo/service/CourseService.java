package com.indra.SpringBootDemo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.SpringBootDemo.model.Course;

public interface CourseService {
	Course getCourseById(long id);
	List<Course> getAllCourses();
	void saveCourse(Course course);
	void deleteCourseById(long id);
	Page<Course> findPaginated(int pageNum, int pageSize,
								String sortField, String sortDirection);
	
}
