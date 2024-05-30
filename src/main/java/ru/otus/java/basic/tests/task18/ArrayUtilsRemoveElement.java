package ru.otus.java.basic.tests.task18;

import java.util.Arrays;

/**
 * Реализуйте метод, который принимает массив целых чисел и одно целое число.
 * А возвращает массив, в котором удалены все вхождения переданного числа.
 */
public class ArrayUtilsRemoveElement {
  public static void main(String[] args) {
    System.out.println(
            "При вводе массива [1, 1, 2, 3, 1] и числа 1, метод должен вернуть [2, 3] - '"
                    + Arrays.toString(removeElement(new int[]{1, 1, 2, 3, 1}, 1))
                    + "'"
    );
  }

  public static int[] removeElement(int[] nums, int val) {
    if (nums == null) {
      return new int[0];
    }

    int count = 0;
    for (int i : nums) {
      if (i == val) {
        count++;
      }
    }

    if (count == 0) {
      return nums;
    }

    int[] temp = new int[nums.length - count];
    int index = 0;
    for (int i : nums) {
      if (i != val) {
        temp[index] = i;
        index++;
      }
    }
    return temp;
  }
}
