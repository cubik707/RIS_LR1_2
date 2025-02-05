package org.example.lr1_2.utils;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;

import java.util.Map;

public class PersistenceManager {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default", Map.of(
    "jakarta.persistence.jdbc.url", EnvConfig.get("DB_URL"),
    "jakarta.persistence.jdbc.user", EnvConfig.get("DB_USER"),
    "jakarta.persistence.jdbc.password", EnvConfig.get("DB_PASSWORD")
  ));

  public static EntityManagerFactory getEntityManagerFactory() {
    return emf;
  }
}
