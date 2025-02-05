package org.example.lr1_2.repository;

import java.util.List;

public interface BaseRepository<T> {
  T findById(int id);
  List<T> findAll();
  void save(T t);
  void delete(int id);
}
