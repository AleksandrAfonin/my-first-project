package ru.otus.java.basic.tests.task17;

import java.util.Arrays;

/**
 * Напишите метод, который получает в качестве параметров двумерный массив целых чисел и целое число.
 * Метод возвращает массив из двух элементов - номера строки и колонки,
 * по которым располагается переданное число. Если число не обнаружено - вывести пустой массив.
 * Если таких чисел несколько вывести последнее.
 */
public class ArrayUtilsFindNumberPosition {
  public static void main(String[] args) {
    int[][] input = new int[][]{{5, 7, 3, 17}, {7, 0, 1, 12}};
    System.out.println(
            "При вводе массива [[5, 7, 3, 17], [7, 0, 1, 12]] и числа 7, метод должен вернуть массив [1, 0] - '"
                    + Arrays.toString(findNumberPosition(input, 7))
                    + "'"
    );
  }

  public static int[] findNumberPosition(int[][] input, int number) {
    if (input == null) {
      return new int[]{};
    }

    if (input.length == 0 || input[0].length == 0) {
      return new int[]{};
    }

    int numberString = -1;
    int numberColumn = -1;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[0].length; j++) {
        if (input[i][j] == number) {
          numberString = i;
          numberColumn = j;
        }
      }
    }

    if (numberString < 0) {
      return new int[]{};
    }

    return new int[]{numberString, numberColumn};
  }
}
