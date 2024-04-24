package ru.otus.java.basic.homework3;

import java.util.Arrays;

public class HomeWork3 {
  public static void main(String[] args) {
    int[][] array = new int[][]{new int[]{3, -4, 1, -4, 7},
            new int[]{-9, 2, 5, 9, -2},
            new int[]{1, -3, -6, 3, 1},
            new int[]{4, -5, 5, 3, -6},
            new int[]{2, 8, 5, -7, -4}
    };

    System.out.println("Сумма положительных элементов: " + sumOfPositiveElements(array));
    printSquare(5);
    zeroDiagonals(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(Arrays.toString(array[i]));
    }
    System.out.println("Максимальное значение в массиве: " + findMax(array));
    System.out.println("Сумма элементов второй строки: " + sumSecondString(array));

  }

  private static int sumOfPositiveElements(int[][] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] > 0) {
          sum += array[i][j];
        }
      }
    }
    return sum;
  }

  private static void printSquare(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  /**
   * Метод зануляет обе диагонали двуменного массива
   * @param array - двумерный массив
   */
  private static void zeroDiagonals(int[][] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].length - 1 - i < 0) {
        return;
      } else {
        array[i][i] = 0;
        array[i][array[i].length - 1 - i] = 0;
      }
    }
  }

  private static int findMax(int[][] array){
    int max = array[0][0];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if(array[i][j] > max){
          max = array[i][j];
        }
      }
    }
    return max;
  }

  private static int sumSecondString(int[][] array){
    int sum = 0;
    if(array.length < 2){
      return -1;
    }else{
      for (int i = 0; i < array[1].length; i++) {
        sum += array[1][i];
      }
    }
    return sum;
  }
}
