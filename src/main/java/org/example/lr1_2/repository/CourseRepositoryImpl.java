package org.example.lr1_2.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.lr1_2.models.Course;

import java.util.List;

@Stateless
public class CourseRepositoryImpl implements CourseRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Course findById(int id) {
    return em.find(Course.class, id);
  }

  @Override
  public List<Course> findAll() {
    TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
    return query.getResultList();
  }

  @Override
  public void save(Course course) {
    if (course.getId() == 0) {
      em.persist(course);
    } else {
      em.merge(course);
    }
  }

  @Override
  public void delete(Course course) {
    em.remove(course);
  }
}
