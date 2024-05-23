package ru.otus.java.basic.homework8;

public class Main {
  public static void main(String[] args) {
    String[][] strings = new String[][]{
            new String[]{"23", "12", "45", "34"},
            new String[]{"76", "04", "87", "22"},
            new String[]{"10", "05", "90k", "31"},
            new String[]{"88", "09", "57", "82"}};
    try {
      System.out.println("Сумма элементов массива: " + sumStringArray(strings));
    } catch (AppArraySizeException | AppArrayDataException e) {
      e.printStackTrace();
    }
  }

  private static int sumStringArray(String[][] stringArray) throws AppArrayDataException, AppArraySizeException {
    if (stringArray.length != 4 || stringArray[0].length != 4) {
      throw new AppArraySizeException("Размерность массива не 4х4");
    }

    int sum = 0;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        try {
          sum += Integer.parseInt(stringArray[i][j]);
        } catch (NumberFormatException e) {
          throw new AppArrayDataException("Элемент массива stringArray[" + i + "][" + j +
                  "] не является числом типа int: \"" + stringArray[i][j] + "\"");
        }
      }
    }
    return sum;
  }
}

