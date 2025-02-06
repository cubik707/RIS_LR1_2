package org.example.lr1_2.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lr1_2.models.Course;
import org.example.lr1_2.service.CourseService;

import java.io.IOException;

@WebServlet("/findCheapestCourse")
public class FindCheapestCourseController extends HttpServlet {
  @EJB
  private CourseService courseService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Course cheapestCourse = courseService.findCheapestCourse();
    req.getSession().setAttribute("cheapestCourse", cheapestCourse);
    res.sendRedirect("courses");
  }
}
