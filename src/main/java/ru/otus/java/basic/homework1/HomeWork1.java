package ru.otus.java.basic.homework1;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class HomeWork1 {
  public static void main(String[] args) {
    greetings();
    checkSign(3, -5, 1);
    selectColor();
    compareNumbers();
    addOrSubtractAndPrint(28, 7, false);

    System.out.println("===================");
    Scanner scanner = new Scanner(System.in);
    int number;
    do {
      System.out.println("Введите число от 1 до 5");
      number = scanner.nextInt();
    } while (number < 1 || number > 5);

    Random random = new Random(LocalTime.now().getSecond());

    if (number == 1) {
      greetings();
    } else if (number == 2) {
      checkSign((int) Math.random() * 100,
              (int) Math.random() * 100,
              (int) Math.random() * 100);
    } else if (number == 3) {
      selectColor();
    } else if (number == 4) {
      compareNumbers();
    } else {
      addOrSubtractAndPrint(random.nextInt(-100, 100),
              random.nextInt(-100, 100),
              random.nextBoolean());
    }
  }

  private static void greetings() {
    System.out.println("Hello");
    System.out.println("World");
    System.out.println("from");
    System.out.println("Java");
  }

  private static void checkSign(int a, int b, int c) {
    System.out.println(a + b + c < 0 ? "Сумма отрицательная" : "Сумма положительная");
  }

  private static void selectColor() {
    int data = 21;
    if (data < 10) {
      System.out.println("Красный");
    } else if (data <= 20) {
      System.out.println("Желтый");
    } else {
      System.out.println("Зеленый");
    }
  }

  private static void compareNumbers() {
    int a = 6;
    int b = 5;
    System.out.println(a >= b ? "a >= b" : "a < b");
  }

  private static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
    if (increment) {
      initValue += delta;
    } else {
      initValue -= delta;
    }
    System.out.println("Result: " + initValue);
  }
}
