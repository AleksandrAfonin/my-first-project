package ru.otus.java.basic.tests.task19;

import java.util.Arrays;

/**
 * Дан массив целочисленных элементов. Реализуйте метод, который сдвигает все элементы массива,
 * кроме первого, на одну позицию влево. Значение, находившееся в начальной ячейке массива,
 * должно перейти в последнюю ячейку (левый сдвиг).
 */
public class ArrayUtilsShiftElements {
  public static void main(String[] args) {
    System.out.println(
            "При вводе массива [1, 2, 3, 4, 5], метод должен вернуть массив [2, 3, 4, 5, 1] - '"
                    + Arrays.toString(shiftElements(new int[]{1, 2, 3, 4, 5}))
                    + "'"
    );
  }

  public static int[] shiftElements(int[] inputArray) {
    if (inputArray == null || inputArray.length < 2) {
      return inputArray;
    }

    int[] temp = new int[inputArray.length];
    int firstElement = inputArray[0];
    for (int i = 1; i < inputArray.length; i++) {
      temp[i - 1] = inputArray[i];
    }

    temp[temp.length - 1] = firstElement;
    return temp;
  }
}
