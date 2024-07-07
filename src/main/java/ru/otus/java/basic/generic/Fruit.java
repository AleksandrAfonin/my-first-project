package ru.otus.java.basic.generic;

public abstract class Fruit {
  private double weight;

  public Fruit(double weight) {
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }
}
