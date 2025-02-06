package org.example.lr1_2.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.example.lr1_2.models.Company;
import org.example.lr1_2.models.Course;
import org.example.lr1_2.repository.company.CompanyRepository;

import java.util.List;

@Stateless
public class CompanyService {
  @EJB
  private CompanyRepository companyRepository;

  public void saveCompany(Company company) {
    if (company.getName() == null || company.getName().isEmpty()) {
      throw new IllegalArgumentException("Company name cannot be empty.");
    }
    companyRepository.save(company);
  }

  public List<Company> findAllCompanies() {
    return companyRepository.findAll();
  }

  public Company findCompanyById(int id) {
    return companyRepository.findById(id);
  }

  public void deleteCompany(int companyId) {
    Company company = companyRepository.findById(companyId);
    if (company == null) {
      throw new IllegalArgumentException("Company with ID " + companyId + " does not exist.");
    }
    companyRepository.delete(company);
  }

  public Company getCompanyByName(String companyName) {
    return companyRepository.findByName(companyName);
  }
}
