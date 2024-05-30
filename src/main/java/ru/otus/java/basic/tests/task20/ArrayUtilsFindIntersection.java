package ru.otus.java.basic.tests.task20;

import java.util.*;

/**
 * Даны два массива с целочисленными элементами. Напишите метод, который возвращает
 * массив со смежными элементами (их пересечение). Если пересечений нет, метод должен
 * вернуть пустой массив.
 */
public class ArrayUtilsFindIntersection {
  public static void main(String[] args) {
    System.out.println(
            "При вводе массивов [1,4,7,3,8] и [9,12,7,4] метод должен вернуть массив [4,7] - '"
                    + Arrays.toString(findIntersection(new int[]{1, 4, 7, 3, 8, 4, 7}, new int[]{4, 7, 9, 12, 7, 4}))
                    + "'"
    );
  }

  public static int[] findIntersection(int[] rightArray, int[] leftArray) {
    if(rightArray == null || leftArray == null || leftArray.length == 0 || rightArray.length == 0){
      return new int[0];
    }

    Set<Integer> set = new TreeSet<>();
    for (int i : rightArray) {
      for (int j : leftArray) {
        if (i == j) {
          set.add(i);
        }
      }
    }

    if(set.isEmpty()){
      return new int[0];
    }

    int[] temp = new int[set.size()];
    int i = 0;
    for (int num : set) {
      temp[i++] = num;
    }

    return temp;
  }
}
