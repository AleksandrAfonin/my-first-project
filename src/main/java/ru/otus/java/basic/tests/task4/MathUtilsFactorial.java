package ru.otus.java.basic.tests.task4;

/**
 * Дано число. Реализовать метод для расчёта факториала числа.
 * Факториал натурального числа n определяется как произведение всех натуральных чисел
 * от 1 до n включительно. Пример: 5! = 1 * 2 * 3 * 4 * 5
 * Факториал от числа 0 всегда равняется 1: 0! = 1
 * Если передано отрицательно число - метод должен вернуть 0
 * Если получаемое в результате число не помещается в памяти метод должен вернуть 0
 */
public class MathUtilsFactorial {
  public static void main(String[] args) {
    System.out.println("Факториал от 5 должен равняться 120 - " + getFactorial((byte) 5));
  }

  public static long getFactorial(byte number) {
    if (number < 0) {
      return 0;
    }

    long factorial = 1L;
    for (int i = number; i > 0; i--) {
      try {
        factorial *= i;
      } catch (Exception e) {
        return 0;
      }
    }
    return factorial;
  }
}
