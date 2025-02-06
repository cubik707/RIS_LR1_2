package org.example.lr1_2.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="companies")
public class Company implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @Column(name="company_name")
  private String name;

  @OneToMany(mappedBy = "company")
  private List<Course> courses;

  public Company() {}

  public Company(String companyName, List<Course> courses) {
    this.name = companyName;
    this.courses = courses;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}
