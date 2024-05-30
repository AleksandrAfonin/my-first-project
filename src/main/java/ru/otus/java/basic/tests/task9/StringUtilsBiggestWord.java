package ru.otus.java.basic.tests.task9;

/**
 * Дана строка, реализовать метод который ищет слово с наибольшим количеством букв.
 * Если таких слов несколько - вывести последнее
 */
public class StringUtilsBiggestWord {
  public static void main(String[] args) {
    System.out.println("При вводе строки \"самое большое слово\" метод должен вернуть \"большое\" - "
            + getLargest("самое большое слово"));
  }

  public static String getLargest(String input) {
    if (input.isEmpty()) {
      return "";
    }

    String[] strs = input.replaceAll("[^A-Za-zА-Яа-я ]", "").trim().split(" ");
    if (strs.length == 0) {
      return "";
    }

    int index = 0;
    int countLetter = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() >= countLetter) {
        countLetter = strs[i].length();
        index = i;
      }
    }

    return strs[index];
  }
}
