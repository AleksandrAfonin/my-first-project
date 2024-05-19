package ru.otus.java.basic.homework7;

import ru.otus.java.basic.homework7.transport.Bicycle;
import ru.otus.java.basic.homework7.transport.Car;
import ru.otus.java.basic.homework7.transport.Horse;

public class Main {
  public static void main(String[] args) {
    Transport car = new Car("Niva", 40);
    Transport bicycle = new Bicycle("Bicycle");
    Transport horse = new Horse("Burka", 200);
    System.out.println(car);
    Human human = new Human("Ivan", 100);
    System.out.println(human);
    human.onTransport(car);
    human.move(10, Terrain.PLAIN);
    System.out.println(human);
    human.leaveTransport();
    human.leaveTransport();
    human.move(20, Terrain.DENSE_FOREST);
    System.out.println(human);
  }
}
