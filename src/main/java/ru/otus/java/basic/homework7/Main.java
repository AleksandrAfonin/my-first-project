package ru.otus.java.basic.homework7;

import ru.otus.java.basic.homework7.transport.Bicycle;
import ru.otus.java.basic.homework7.transport.Car;
import ru.otus.java.basic.homework7.transport.Horse;
import ru.otus.java.basic.homework7.transport.Transport;

public class Main {
  public static void main(String[] args) {
    Transport car = new Car("Niva", 40);
    Transport car2 = new Car("Geely", 400);
    Transport bicycle = new Bicycle("Bicycle");
    Transport horse = new Horse("Burka", 200);
    System.out.println(car);
    System.out.println(bicycle);
    Human human = new Human("Ivan", 100);
    Human human1 = new Human("Igor", 150);
    System.out.println(human);
    System.out.println(human1);
    human.onTransport(car);
    human.leaveTransport();
    human.onTransport(car2);
    human1.onTransport(bicycle);

    human.move(10, Terrain.PLAIN);
    System.out.println(human);
    human.leaveTransport();
    human1.onTransport(car);
    human.leaveTransport();
    human.onTransport(bicycle);
    human1.move(30, Terrain.DENSE_FOREST);
    System.out.println(human);
    System.out.println(human1);
  }
}
