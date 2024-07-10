package ru.otus.java.basic.generic;

public class Apple extends Fruit {

  public Apple(double weight) {
    super(weight);
  }

  @Override
  public String toString() {
    return "Apple{" +
            "weight='" + getWeight() + '\'' +
            '}';
  }
}
