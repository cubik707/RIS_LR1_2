package org.example.lr1_2.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.example.lr1_2.models.Course;
import org.example.lr1_2.repository.CourseRepository;

import java.util.List;

@Stateless
public class CourseService {
  @EJB
  CourseRepository courseRepository;

  public void saveCourse(Course course) {
    if (course.getName() == null || course.getName().isEmpty()) {
      throw new IllegalArgumentException("Course name cannot be empty");
    }
    courseRepository.save(course);
  }

  public Course findCourseById(int id) {
    return courseRepository.findById(id);
  }

  public List<Course> findAllCourses() {
    return courseRepository.findAll();
  }

  public void deleteCourse(int courseId) {
    Course course = courseRepository.findById(courseId);
    if(course == null) {
      throw new IllegalArgumentException("Course with ID" + courseId + " does not exist.");
    }
    courseRepository.delete(course);
  }
}
