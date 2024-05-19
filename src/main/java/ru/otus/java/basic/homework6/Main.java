package ru.otus.java.basic.homework6;

public class Main {

  public static void main(String[] args) {

    Plate plate = new Plate(40);

    Cat[] cats = {
            new Cat("Barsik", 10),
            new Cat("Murzik", 8),
            new Cat("Pushok", 11),
            new Cat("Pufik", 14)
    };

    for (Cat cat : cats) {
      cat.eat(plate);
    }

    for (Cat cat : cats) {
      System.out.println(cat);
    }

    System.out.println(plate);
  }


}
