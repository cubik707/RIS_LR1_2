package org.example.lr1_2.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lr1_2.service.CourseService;

import java.io.IOException;

@WebServlet("/calculatePrice")
public class CalculatePriceController extends HttpServlet {
  @EJB
  private CourseService courseService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    int companyId = Integer.parseInt(req.getParameter("companyId"));
    double totalPrice = courseService.calculateTotalPriceForCompany(companyId);
    courseService.writeTotalPriceToFile(totalPrice);

    req.getSession().setAttribute("totalPrice", totalPrice);
    res.sendRedirect("courses");
  }
}
