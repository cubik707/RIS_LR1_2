package org.example.lr1_2.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
  private static final Dotenv dotenv = Dotenv.load();

  public static String get(String key) {
    return dotenv.get(key);
  }
}

