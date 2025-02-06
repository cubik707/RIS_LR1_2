package org.example.lr1_2.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.example.lr1_2.models.Company;
import org.example.lr1_2.models.Course;
import org.example.lr1_2.repository.company.CompanyRepository;
import org.example.lr1_2.repository.course.CourseRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Stateless
public class CourseService {

  @EJB
  CourseRepository courseRepository;
  @EJB
  private CompanyRepository companyRepository;

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

  public double calculateTotalPriceForCompany(int companyId) {
    Company company = companyRepository.findById(companyId);
    List<Course> courses = company.getCourses();
    double totalPrice = 0;

    for (Course course : courses) {
      totalPrice += course.getPricePerMonth();
    }

    return totalPrice;
  }

  // Нахождение самого дешевого курса
  public Course findCheapestCourse() {
    List<Course> courses = courseRepository.findAll();
    Course cheapest = null;

    for (Course course : courses) {
      if (cheapest == null || course.getPricePerMonth() < cheapest.getPricePerMonth()) {
        cheapest = course;
      }
    }

    return cheapest;
  }

  public void writeTotalPriceToFile(double totalPrice) {
    try (FileWriter writer = new FileWriter("total_price.txt", true)) {
      writer.write("Total Price: " + totalPrice + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
