package ru.otus.java.basic.homework7;

public interface Transport {
  boolean move(int distance, Terrain terrain);
  String getName();
  String getResource();
}
