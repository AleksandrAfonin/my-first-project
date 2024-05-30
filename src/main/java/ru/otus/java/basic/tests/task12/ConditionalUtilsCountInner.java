package ru.otus.java.basic.tests.task12;

/**
 * Реализуйте метод, который принимает два положительных числа - двузначное и четырехзначное - и проверяет,
 * сколько раз двузначное число встречается как «внутреннее» по отношению к четырехзначному.
 */
public class ConditionalUtilsCountInner {

  public static void main(String[] args) {
    System.out.println("При вводе чисел 6522 и 22 метод должен вернуть 1 - "
            + countInnerNumber(6522, 22));
  }

  public static int countInnerNumber(int base, int checkNumber) {
    String baseStr = String.valueOf(base);
    String checkNumberStr = String.valueOf(checkNumber);
    int count = 0;
    int index = 0;
    while (true) {
      index = baseStr.indexOf(checkNumberStr, index);
      if (index != -1) {
        count++;
        index++;
      } else {
        break;
      }
    }

    return count;
  }
}
