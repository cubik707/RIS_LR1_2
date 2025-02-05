package org.example.lr1_2.models;

import jakarta.persistence.*;

@Entity
@Table(name="companies")
public class Company {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @Column(name="company_name")
  private String name;

  public Company() {}

  public Company(String companyName) {
    this.name = companyName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
