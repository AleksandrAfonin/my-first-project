package ru.otus.java.basic.tests.task13;

/**
 * Реализуйте метод, который принимает трёхзначное число и проверяет,
 * является ли оно "дважды чётным" (сумма и произведение его цифр являются чётными)
 * Если переданное число имеет больше или меньше чисел чем 3 метод должен вернуть отрицательный результат.
 */
public class ConditionalUtilsTwiceEven {

  public static void main(String[] args) {
    System.out.println("При вводе числа 222 метод должен вернуть true - " + isDoublePrime(222));
  }

  public static boolean isDoublePrime(int inputNumber) {
    if (inputNumber < 100 || inputNumber > 999) {
      return false;
    }

    int sum = 0;
    int mult = 1;
    String str = String.valueOf(inputNumber);
    for (int i = 0; i < 3; i++) {
      int num = Integer.valueOf(str.charAt(i));
      sum += num;
      mult *= num;
    }

    return (sum & 1) == 0 && (mult & 1) == 0;
  }
}
