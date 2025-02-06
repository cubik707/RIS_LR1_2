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
import java.util.List;

@WebServlet("/courses")
public class CourseController extends HttpServlet {
  @EJB
  private CourseService courseService;
  @EJB
  private CompanyService companyService;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    List<Course> courses = courseService.findAllCourses();
    List<Company> companies = companyService.findAllCompanies();

    req.setAttribute("courses", courses);
    req.setAttribute("companies", companies);


    // Переносим cheapestCourse из сессии в request и убираем из сессии
    Object cheapestCourse = req.getSession().getAttribute("cheapestCourse");
    if (cheapestCourse != null) {
      req.setAttribute("cheapestCourse", cheapestCourse);
      req.getSession().removeAttribute("cheapestCourse");
    }

    // Получаем totalPrice из сессии, если есть, и удаляем из сессии
    Object totalPrice = req.getSession().getAttribute("totalPrice");
    if (totalPrice != null) {
      req.setAttribute("totalPrice", totalPrice);
      req.getSession().removeAttribute("totalPrice");
    }

    req.getRequestDispatcher("courses.jsp").forward(req, res);
  }
}
