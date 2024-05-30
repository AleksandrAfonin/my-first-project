package ru.otus.java.basic.tests.task10;

/**
 * Дана строка, реализуйте метод, который позволяет получать подстроку по заданным индексам
 * Пример getSlice("Test", 1, 4) - вернёт "est"
 */
public class StringUtilsSliceWord {
  public static void main(String[] args) {
    System.out.println("При вводе строки \"Test\" с индексами 1 и 4 метод должен вернуть \"est\" - "
            + "\"" + getSlice("Test", 1, 4) + "\"");

  }

  public static String getSlice(String input, int leftEdge, int rightEdge) {
    if (leftEdge < 0 || rightEdge > input.length() || leftEdge > rightEdge) {
      return input;
    }
    return input.substring(leftEdge, rightEdge);
  }
}
