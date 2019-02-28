package io.javabrains.springbootstarter.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> Courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(Courses::add);
		 return Courses;
	}
	
	public Course getCourse(String id) {
	//	return topicList.stream().filter(t->t.getId().equals(id)).findFirst().get();
	 return	courseRepository.findById(id).orElse(null);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		/*
		 * System.out.println(topic.getId()); for(int i=0;i<topicList.size();i++) {
		 * Course t= topicList.get(i); if(t.getId().equals(topic.getId())) {
		 * topicList.set(i, topic) ; return; }
		 * 
		 * }
		 */
		courseRepository.save(course);
	
}
	
	public void delete(String id) {
		//topicList.removeIf(t->t.getId().equals(id));
		courseRepository.deleteById(id);
	}
	
	
}
