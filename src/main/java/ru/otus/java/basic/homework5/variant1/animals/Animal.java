package ru.otus.java.basic.homework5.variant1.animals;

public abstract class Animal {
  String name;
  int runSpeed;
  int endurance;
  int runningEnduranceCosts;
  boolean isFatigue;

  public String getName() {
    return name;
  }

  public Animal(String name, int runSpeed, int endurance) {
    this.name = name;
    this.runSpeed = runSpeed;
    this.endurance = endurance;
    this.runningEnduranceCosts = 1;
    this.isFatigue = false;
  }

  public int run(int distance) {
    if (distance < 1) {
      System.out.println("Нет дистанции как таковой");
      return 0;
    }
    if (distance * this.runningEnduranceCosts > this.endurance) {
      this.endurance = 0;
      this.isFatigue = true;
      System.out.println("Не хватило выносливости");
      return -1;
    }
    this.endurance -= distance * this.runningEnduranceCosts;
    int time = distance / this.runSpeed;
    System.out.println("Затраченное время: " + time + " сек.");
    return time;
  }

  public void info() {
    System.out.println("Имя: " + this.name);
    System.out.println("Скорость бега: " + this.runSpeed + " м/с");
    System.out.println("Выносливость: " + this.endurance + " у.е.");
    System.out.println("Затраты выносливости на бег: " + this.runningEnduranceCosts + " у.е.");
    System.out.println(this.isFatigue ? "В состоянии усталости" : "Нет состояния усталости");
  }
}