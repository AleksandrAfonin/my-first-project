package ru.otus.java.basic.homework7.transport;

import ru.otus.java.basic.homework7.Human;
import ru.otus.java.basic.homework7.Terrain;

public interface Transport {
  boolean move(int distance, Terrain terrain);

  boolean addDriver(Human human);

  boolean deleteDriver();

  String getName();

  String getResource();


}
