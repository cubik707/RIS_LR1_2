package org.example.lr1_2.models;

import jakarta.persistence.*;

@Entity
@Table(name="courses")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="course_name")
  private String name;

  @Column(name="price_per_month")
  private double pricePerMonth;

  @Enumerated(EnumType.STRING)
  @Column(name="payment_method")
  private PaymentMethod paymentMethod;

  @ManyToOne
  @JoinColumn(name="company_id")
  private Company company;

  public Course() {}

  public Course(String courseName, double pricePerMonth, PaymentMethod paymentMethod, Company company) {
    this.name = courseName;
    this.pricePerMonth = pricePerMonth;
    this.paymentMethod = paymentMethod;
    this.company = company;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPricePerMonth() {
    return pricePerMonth;
  }

  public void setPricePerMonth(double pricePerMonth) {
    this.pricePerMonth = pricePerMonth;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
