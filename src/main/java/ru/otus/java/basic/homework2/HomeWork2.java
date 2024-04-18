package ru.otus.java.basic.homework2;

import java.util.Arrays;

public class HomeWork2 {
  public static void main(String[] args) {
    printStrings(4, "It is the printStrings method.");

    sumValuesMoreFive(new int[]{3, 6, 1, 2, 8, 11});

    int[] array = {45, 23, 31, 6, 1, 33};
    fillArrayWithNumber(10, array);
    System.out.println("Array: " + Arrays.toString(array));

    increaseItems(5, array);
    System.out.println("Increase array: " + Arrays.toString(array));

    int[] array2 = {23, 43, 76, 12, 23, 53};
    sumOfHalvesOfArrayAndPrint(array2);

    System.out.println("===========================");

    System.out.println("Result: " + Arrays.toString(sumArrays(
            new int[]{2, 4, 3},
            new int[]{7, 1, 2, 1},
            new int[]{3, 9})));

    if (equalitySumsHalvesOfArray(new int[]{23, 2, 24, 1})) {
      System.out.println("The border is exist");
    } else {
      System.out.println("The border is not exist");
    }

    System.out.println("check for increasing:");
    if(checkIncreasingDecreasing(new int[] {1, 2, 3, 2}, true)){
      System.out.println("Increasing");
    }else {
      System.out.println("Not increasing");
    }

    System.out.println("check for decreasing:");
    if(checkIncreasingDecreasing(new int[] {10, 8, 6, 4}, false)){
      System.out.println("Decreasing");
    }else {
      System.out.println("Not decreasing");
    }

    System.out.println("Reverse array:");
    reversArray(array2);
    System.out.println(Arrays.toString(array2));
  }

  private static void printStrings(int count, String str) {
    if (count < 0) {
      count = 0;
    }
    while (count-- > 0) {
      System.out.println(str);
    }
  }

  private static void sumValuesMoreFive(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > 5) {
        sum += array[i];
      }
    }
    System.out.println("Sum = " + sum);
  }

  private static void fillArrayWithNumber(int number, int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = number;
    }
    // Есть готовый метод из java.util.Arrays
  }

  private static void increaseItems(int number, int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] += number;
    }
  }

  private static void sumOfHalvesOfArrayAndPrint(int[] array) {
    int sumRight = 0;
    int sumLeft = 0;

    for (int i = 0; i < array.length / 2; i++) {
      sumLeft += array[i];
    }
    for (int i = array.length / 2; i < array.length; i++) {
      sumRight += array[i];
    }

    if (sumLeft > sumRight) {
      System.out.println("The sum of the left half of the array elements is greater");
    } else if (sumRight > sumLeft) {
      System.out.println("The sum of the right half of the array elements is greater");
    } else {
      System.out.println("The sums of the right and left halves are equal");
    }
  }

  private static int[] sumArrays(int[]... arrays) {
    int maxSize = 0;
    for (int[] array : arrays) {
      if (array.length > maxSize) {
        maxSize = array.length;
      }
    }
    int[] result = new int[maxSize];
    for (int i = 0; i < arrays.length; i++) {
      for (int j = 0; j < arrays[i].length; j++) {
        result[j] += arrays[i][j];
      }
    }
    return result;
  }

  private static boolean equalitySumsHalvesOfArray(int[] array) {
    if (array.length < 2) {
      System.out.println("The size of array less 2");
      return false;
    }

    int sumItems = 0;

    for (int i = 0; i < array.length; i++) {
      sumItems += array[i];
    }

    int sumLeft = 0;
    int i = 0;

    for (; i < array.length; i++) {
      if ((sumLeft += array[i]) == (sumItems -= array[i])) {
        break;
      }
    }

    if (i == array.length) {
      System.out.println("There is no such point");
      return false;
    }

    System.out.println("The point is located:");
    System.out.print("{");

    for (int j = 0; j < array.length; j++) {
      System.out.print(array[j] + ", ");
      if (i == j) {
        System.out.print("| ");
      }
    }

    System.out.println("\b\b}");
    return true;
  }

  private static boolean checkIncreasingDecreasing(int[] array, boolean isIncreasing) {
    boolean result = true;
    if (isIncreasing) {
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
          result = false;
          break;
        }
      }
    } else {
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] < array[i + 1]) {
          result = false;
          break;
        }
      }
    }
    return result;
  }

  private static void reversArray(int[] array){
    int temp;
    for (int i = 0; i < array.length / 2; i++) {
      temp = array[i];
      array[i] = array[array.length - i - 1];
      array[array.length - i - 1] = temp;
    }
  }
}