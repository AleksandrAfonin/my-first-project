package ru.otus.java.basic.tests.task2;

/**
 * Дана строка, состоящая из скобок, а также открывающий и закрывающий символ скобок.
 * Необходимо реализовать метод, который проверяет что в строке у каждой открывающей скобки
 * есть соответствующая ей закрывающая скобка. Строка в которой закрывающая скобка
 * идёт впереди открывающей является некорректной.
 * Например (()) - корректная строка, ()) - некорректная строка
 */
public class BracketUtils {
  public static void main(String[] args) {
    System.out.println(isCorrectBrackets("for (int i = 0; i < input.length(); i++)", '(', ')'));
    System.out.println(isCorrectBrackets("for (int i = 0; i < input.length(); i++))", '(', ')'));
  }
  
  public static boolean isCorrectBrackets(String input, char bracketOpenSymbol, char bracketCloseSymbol){
    int countBrackets = 0;

    for (int i = 0; i < input.length(); i++) {
      if(input.charAt(i) == bracketCloseSymbol){
        if(countBrackets == 0){
          return false;
        }

        countBrackets--;
      }

      if(input.charAt(i) == bracketOpenSymbol){
        countBrackets++;
      }
    }

    return countBrackets == 0;
  }
}
