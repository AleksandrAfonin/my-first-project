package ru.otus.java.basic.homework5.variant2.animals;

public class Dog extends SwimmingAnimal {

  public Dog(String name, int runSpeed, int swimSpeed, int endurance) {
    super(name, runSpeed, swimSpeed, endurance);
    this.swimmingEnduranceCosts = 2;
  }
}
