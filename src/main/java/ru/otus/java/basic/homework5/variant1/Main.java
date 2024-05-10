package ru.otus.java.basic.homework5.variant1;

import ru.otus.java.basic.homework5.variant1.animals.Cat;
import ru.otus.java.basic.homework5.variant1.animals.Dog;
import ru.otus.java.basic.homework5.variant1.animals.Horse;

public class Main {
  public static void main(String[] args) {
    Cat cat1 = new Cat("Barsic", 3, 300);
    cat1.info();
    System.out.println();
    System.out.println(cat1.getName() + " бежит 45 метров:");
    cat1.run(45);
    System.out.println();
    cat1.info();
    System.out.println("===================================");
    Dog dog1 = new Dog("Bobik", 4, 2, 400);
    dog1.info();
    System.out.println();
    System.out.println(dog1.getName() + " бежит 45 метров:");
    dog1.run(45);
    System.out.println();
    dog1.info();
    System.out.println();
    System.out.println(dog1.getName() + " плывет 30 метров:");
    dog1.swim(30);
    System.out.println();
    dog1.info();
    System.out.println("====================================");
    Horse horse1 = new Horse("Voronok", 5, 3, 500);
    horse1.info();
    System.out.println();
    System.out.println(horse1.getName() + " бежит 150 метров:");
    horse1.run(150);
    System.out.println();
    horse1.info();
    System.out.println();
    System.out.println(horse1.getName() + " плывет 60 метров:");
    horse1.swim(60);
    System.out.println();
    horse1.info();
  }
}
