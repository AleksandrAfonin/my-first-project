package ru.otus.java.basic.homework5.variant1.animals;

public class Dog extends Animal {
  int swimSpeed;
  int swimmingEnduranceCosts;

  public Dog(String name, int runSpeed, int swimSpeed, int endurance) {
    super(name, runSpeed, endurance);
    this.swimSpeed = swimSpeed;
    this.swimmingEnduranceCosts = 2;
  }

  public int swim(int distance) {
    if (distance < 1) {
      System.out.println("Нет дистанции как таковой");
      return 0;
    }
    if (distance * this.swimmingEnduranceCosts > this.endurance) {
      this.endurance = 0;
      this.isFatigue = true;
      System.out.println("Не хватило выносливости");
      return -1;
    }
    this.endurance -= distance * this.swimmingEnduranceCosts;
    int time = distance / this.swimSpeed;
    System.out.println("Затраченное время: " + time + " сек.");
    return time;
  }

  @Override
  public void info() {
    System.out.println("Имя: " + this.name);
    System.out.println("Скорость бега: " + this.runSpeed + " м/с");
    System.out.println("Скорость плавания: " + this.swimSpeed + " м/с");
    System.out.println("Выносливость: " + this.endurance + " у.е.");
    System.out.println("Затраты выносливости на бег: " + this.runningEnduranceCosts + " у.е.");
    System.out.println("Затраты выносливости на плавание: " + this.swimmingEnduranceCosts + " у.е.");
    System.out.println(this.isFatigue ? "В состоянии усталости" : "Нет состояния усталости");
  }
}
