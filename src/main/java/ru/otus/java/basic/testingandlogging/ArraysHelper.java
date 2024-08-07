package ru.otus.java.basic.testingandlogging;

import java.util.Arrays;

public class ArraysHelper {

  public int[] itemsAfterOne(int[] array) {
    if (array == null) {
      throw new RuntimeException();
    }
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == 1) {
        return Arrays.copyOfRange(array, i + 1, array.length);
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
    for (int i : array) {
      if (i == 1) {
        containsOne = true;
      } else if (i == 2) {
        containsTwo = true;
      } else {
        return false;
      }
    }
    return containsOne && containsTwo;
  }
}
