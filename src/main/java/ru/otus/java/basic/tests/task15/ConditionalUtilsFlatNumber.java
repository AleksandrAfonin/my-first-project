package ru.otus.java.basic.tests.task15;

/**
 * Реализуйте метод, который принимает трёхзначное число и проверяет, является ли оно плоским.
 * Пример плоских чисел: 111, 777, 333. Если переданное число имеет больше или меньше чисел
 * чем 3 метод должен вернуть отрицательный результат.
 */
public class ConditionalUtilsFlatNumber {
  public static void main(String[] args) {
    System.out.println("При вводе числа 777 метод должен вернуть true - " + isDescendingNumber(777));
  }

  public static boolean isDescendingNumber(int inputNumber) {
    if (inputNumber < 100 || inputNumber > 999) {
      return false;
    }
    String str = String.valueOf(inputNumber);
    char ch = str.charAt(0);
    return ch == str.charAt(1) && ch == str.charAt(2);
  }
}
