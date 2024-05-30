package ru.otus.java.basic.tests.task1;

/**
 * Дана строка, состоящая из слов, разделенных пробелами.
 * Необходимо реализовать метод, который возвращает строку, слова в которой записаны в обратном порядке.
 * Например, для строки "test abc" необходимо получить строку "abc test".
 */
public class WordUtils {
  public static void main(String[] args) {
    System.out.println(reverseWords(""));
    System.out.println(reverseWords("word"));
    System.out.println(reverseWords("Hello my best friend !"));
  }

  public static String reverseWords(String inputText) {
    if (inputText.isEmpty()) {
      return "";
    }

    String[] words = inputText.trim().split(" ");
    if (words.length == 1) {
      return inputText;
    }

    StringBuilder str = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      str.append(words[i]);
      str.append(" ");
    }
    str.delete(str.length() - 1, str.length());
    return str.toString();
  }
}
