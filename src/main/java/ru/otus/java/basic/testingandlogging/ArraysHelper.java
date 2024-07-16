package ru.otus.java.basic.testingandlogging;

import java.util.Arrays;

public class ArraysHelper {

  public int[] itemsAfterOne(int[] array) {
    if (array == null) {
      throw new RuntimeException();
    }
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == 1) {
        int[] newArray = Arrays.copyOfRange(array, i + 1, array.length);
        return newArray;
      }
    }
    throw new RuntimeException();
  }

  public boolean containsOneAndTwo(int[] array) {
    if (array == null) {
      return false;
    }
    boolean containsOne = false;
    boolean containsTwo = false;
    for (int j : array) {
      if (j == 1) {
        containsOne = true;
        continue;
      } else if (j == 2) {
        containsTwo = true;
        continue;
      }
      return false;
    }
    return containsOne && containsTwo;
  }
}
