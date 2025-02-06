package org.example.lr1_2.repository.company;

import org.example.lr1_2.models.Company;
import org.example.lr1_2.repository.BaseRepository;

public interface CompanyRepository extends BaseRepository<Company> {
  public Company findByName(String companyName);
}
