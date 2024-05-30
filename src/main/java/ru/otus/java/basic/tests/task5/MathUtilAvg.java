package ru.otus.java.basic.tests.task5;

/**
 * Даны 2 числа. Реализуйте метод, который вычисляет все чётные числа
 * между переданными числами и выводит из них среднее значение.
 * Если получается дробное значение метод должен округлить число до целого в меньшую сторону.
 * Если хотя бы одно число из переданных является отрицательным метод должен вернуть 0.
 * Первое переданное число должно быть всегда меньше второго иначе метод должен вернуть 0.
 */
public class MathUtilAvg {
  public static void main(String[] args) {
    System.out.println("avg четных чисел у ряда с 1 до 10 должен равняться 6 - "
            + getPrimeNumbersSum((byte) 1, (byte) 10));
  }

  public static int getPrimeNumbersSum(byte lowEdge, byte highEdge) {
    if (lowEdge < 0 || highEdge < 0 || lowEdge >= highEdge) {
      return 0;
    }

    int number = (lowEdge & 1) == 0 ? lowEdge : ++lowEdge;
    int sum = 0;
    int count = 0;
    for (int i = number; i <= highEdge; i += 2) {
      sum += i;
      count++;
    }

    return sum / count;
  }
}
