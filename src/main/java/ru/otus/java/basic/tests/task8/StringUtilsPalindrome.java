package ru.otus.java.basic.tests.task8;

/**
 * Реализовать метод, который проверяет что переданная на вход строка является палиндромом
 * (то есть читается одинаково в обоих направлениях) Примеры строк-палиндромов:
 * шалаш; доход; заказ; Лёша на полке клопа нашёл Все знаки препинания,
 * цифры и специальные символы должны игнорироваться методом в вычислении палиндрома
 * Если переданная строка состоит только из спецсимволов, то метод должен вернуть false
 */
public class StringUtilsPalindrome {

  public static void main(String[] args) {
    System.out.println("При вводе строки \"шалаш\" метод должен вернуть true - " + isPalindrome("шалаш"));
  }

  public static boolean isPalindrome(String input) {
    String str = input.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase();
    if (str.isEmpty()) {
      return false;
    }

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }
}
