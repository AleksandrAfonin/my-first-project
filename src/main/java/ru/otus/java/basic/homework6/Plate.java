package ru.otus.java.basic.homework6;

public class Plate {
  private int maxFood;
  private int currentFood;

  public Plate(int maxFood) {
    this.maxFood = maxFood;
    this.currentFood = maxFood;
  }

  public void addFood(int food) {
    if (this.currentFood + food > this.maxFood) {
      this.currentFood = this.maxFood;
    } else {
      this.currentFood += food;
    }
  }

  public boolean decreaseFood(int food) {
    if (this.currentFood - food < 0) {
      return false;
    }
    this.currentFood -= food;
    return true;
  }

  @Override
  public String toString() {
    return "Plate{" +
            "maxFood=" + maxFood +
            ", currentFood=" + currentFood +
            '}';
  }
}
