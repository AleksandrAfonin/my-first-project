package ru.otus.java.basic.tests.task14;

/**
 * Реализуйте метод, который принимает номер года и проверяет високосный ли он или нет.
 */
public class ConditionalUtilsLeapYear {
  public static void main(String[] args) {
    System.out.println("При вводе числа 2004, метод должен вернуть true - " + isLeapYear(2004));
  }

  public static boolean isLeapYear(int inputYear) {
    if (inputYear < 0) {
      return false;
    }
    return inputYear % 4 == 0;
  }
}
