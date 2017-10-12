package com.vm.course.api.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	 @PersistenceContext(unitName = "primaryPU")
	 private EntityManager entityManager;

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	} 
    @Transactional(value = "primaryTransactionManager")
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

}
