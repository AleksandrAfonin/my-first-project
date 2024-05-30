package ru.otus.java.basic.tests.task3;

import java.math.BigInteger;

/**
 * Дано число. Реализуйте метод, который вычисляет числа Фибоначчи (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...),
 * находит их сумму и возвращает её в виде строки.
 * Формула расчёта чисел: Fn = Fn-1 + Fn-2 - где n переданное в метод число.
 * Например для n=5 сумма будет равна 7, а для n=2 сумма будет равна 1.
 * Если в метод передано отрицательное число - он должен вернуть 0.
 */
public class FibonacciUtils {
  public static void main(String[] args) {
    System.out.println(getFibonacciSum((byte) 127));
  }

  public static String getFibonacciSum(byte limit) {
    if (limit < 2) {
      return "0";
    }

    BigInteger number1 = BigInteger.valueOf(0);
    BigInteger number2 = BigInteger.valueOf(1);
    BigInteger sum = BigInteger.valueOf(1);

    for (int i = 2; i < limit; i++) {
      BigInteger nextNumber = number1.add(number2);
      number1 = number2;
      number2 = nextNumber;
      sum = sum.add(nextNumber);
    }

    return sum.toString();
  }
}
