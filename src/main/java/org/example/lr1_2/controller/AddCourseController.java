package org.example.lr1_2.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lr1_2.models.Company;
import org.example.lr1_2.models.Course;
import org.example.lr1_2.models.PaymentMethod;
import org.example.lr1_2.service.CompanyService;
import org.example.lr1_2.service.CourseService;

import java.io.IOException;

@WebServlet("/addCourse")
public class AddCourseController extends HttpServlet {

  @EJB
  private CourseService courseService;

  @EJB
  private CompanyService companyService;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String courseName = req.getParameter("courseName");
    double pricePerMonth = Double.parseDouble(req.getParameter("pricePerMonth"));
    String paymentMethod = req.getParameter("paymentMethod");
    String companyName = req.getParameter("companyName");

    // Преобразование строки в enum
    PaymentMethod paymentEnum = PaymentMethod.valueOf(paymentMethod);

    Company company = companyService.getCompanyByName(companyName);
    if (company == null) {
      req.setAttribute("errorMessage", "Company not found!");
      req.getRequestDispatcher("addCourse.jsp").forward(req, res);
      return;
    }

    // Создаем новый курс и сохраняем его
    Course course = new Course(courseName, pricePerMonth, paymentEnum, company);
    courseService.saveCourse(course);

    res.sendRedirect("courses");
  }
}
