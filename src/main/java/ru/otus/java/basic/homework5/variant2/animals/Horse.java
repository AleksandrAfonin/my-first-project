package ru.otus.java.basic.homework5.variant2.animals;

public class Horse extends SwimmingAnimal {

  public Horse(String name, int runSpeed, int swimSpeed, int endurance) {
    super(name, runSpeed, swimSpeed, endurance);
    this.swimmingEnduranceCosts = 4;
  }
}
