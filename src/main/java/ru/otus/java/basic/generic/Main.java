package ru.otus.java.basic.generic;

public class Main {
  public static void main(String[] args) {
    Box<Apple> apples = new Box<>();
    apples.add(new Apple(1.0));
    Box<Apple> apples2 = new Box<>();
    apples2.add(new Apple(1.9));

    Box<Orange> oranges = new Box<>();
    oranges.add(new Orange(1.1));
    System.out.println("Box apples: " + apples);
    System.out.println("Box oranges: " + oranges);

    Box<Fruit> fruits = new Box<>();
    fruits.add(new Apple(1.1));
    fruits.add(new Orange(1.2));
    System.out.println("Box fruits: " + fruits);
    System.out.println("===================");
    System.out.println(fruits.compare(apples));
    System.out.println(apples.compare(oranges));
    System.out.println("===================");
    apples.refillingTo(fruits);
    oranges.refillingTo(fruits);

    System.out.println("Box apples: " + apples);
    System.out.println("Box oranges: " + oranges);
    System.out.println("Box fruits: " + fruits);
    System.out.println("Box apples2: " + apples2);
  }
}
