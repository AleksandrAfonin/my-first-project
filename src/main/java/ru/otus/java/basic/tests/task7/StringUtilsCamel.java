package ru.otus.java.basic.tests.task7;

import java.util.Locale;

/**
 * Дана строка. Реализуйте метод который бы приводил полученную строку к camel case нотации.
 * Если встречаются знаки препинания, иные специальные символы или цифры - они должны быть удалены.
 * Пример: входная строка - my camel * case string 1, результат - myCamelCaseString
 */
public class StringUtilsCamel {

  public static void main(String[] args) {
    System.out.println("Строка \"my camel * case string 1\" должна преобразоваться в myCamelCaseString - "
            + toCamelCase("my camel * case string 1"));
  }

  public static String toCamelCase(String input) {
    if (input.isEmpty()) {
      return "";
    }

    String[] strs = input.replaceAll("[^A-Za-zА-Яа-я ]", "").trim().split(" ");
    StringBuilder sb = new StringBuilder(strs[0].toLowerCase());
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() > 0) {
        sb.append(strs[i].substring(0, 1).toUpperCase());
        if (strs[i].length() > 1) {
          sb.append(strs[i].substring(1).toLowerCase());
        }
      }
    }
    return sb.toString();
  }
}
