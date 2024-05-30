package ru.otus.java.basic.tests.task11;

/**
 * Реализуйте метод, который считает количество упоминаний указанного слова в строке
 * Пример countWord(""Test string for test"", test) должен вернуть 2
 */
public class StringUtilsCountWord {
  public static void main(String[] args) {
    System.out.println("При вводе строки \"Test string for test\" и искомом слове \"test\" метод должен вернуть 2 - "
            + countWord("Test string for test", "test"));
  }

  public static int countWord(String input, String word) {
    if (input.isEmpty() || word.isEmpty()) {
      return 0;
    }

    String str = input.toLowerCase();
    String wordCompare = word.toLowerCase();
    int index = 0;
    int count = 0;
    while (true) {
      index = str.indexOf(wordCompare, index);
      if (index != -1) {
        index += word.length();
        count++;
      } else {
        break;
      }
    }

    return count;
  }
}
