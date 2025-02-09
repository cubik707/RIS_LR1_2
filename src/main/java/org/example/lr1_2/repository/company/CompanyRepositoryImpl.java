package org.example.lr1_2.repository.company;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.lr1_2.models.Company;

import java.util.List;

@Stateless
public class CompanyRepositoryImpl implements CompanyRepository {
  @PersistenceContext
  private EntityManager em;

  @Override
  public Company findById(int id) {
    return em.find(Company.class, id);
  }

  @Override
  public List<Company> findAll() {
    TypedQuery<Company> query = em.createQuery("SELECT c FROM Company c", Company.class);
    return query.getResultList();
  }

  @Override
  public void save(Company company) {
    if (company.getId() == 0) {
      em.persist(company);
    } else {
      em.merge(company);
    }
  }

  @Override
  public void delete(Company company) {
    em.remove(company);
  }

  @Override
  public Company findByName(String companyName) {
    TypedQuery<Company> query = em.createQuery("SELECT c FROM Company c WHERE c.name = :companyName", Company.class);
    query.setParameter("companyName", companyName);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
