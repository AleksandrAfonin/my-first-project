package ru.otus.java.basic.iopart2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    String[] items;
    do {
      System.out.println("Enter the file name and sequence. For example: text.txt abc");
      String enterString = scanner.nextLine();
      items = enterString.trim().split(" ");
      if (items.length != 2) {
        System.out.println("Incorrect input");
      } else {
        break;
      }
    } while (true);
    int count = countingSequence(items[0], items[1]);
    if (count != -1) {
      System.out.println("In the '" + items[0] + "' file, the sequence is repeated " + count + " times");
    }
  }

  public static int countingSequence(String fileName, String sequence) {
    if (sequence.isEmpty()) {
      return 0;
    }
    char[] chars = new char[sequence.length()];
    Arrays.fill(chars, ' ');
    int count = 0;

    try (FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8)) {
      int c;
      int index = chars.length - 1;
      while ((c = fileReader.read()) != -1) {
        chars[index] = (char) c;
        if (compareSequence(chars, sequence)) {
          count++;
        }
        roll(chars);
      }
      return count;
    } catch (FileNotFoundException e) {
      System.out.println("The file is not found");
      return -1;
    } catch (IOException e) {
      System.out.println("I/O error");
      return -1;
    }
  }

  private static boolean compareSequence(char[] chars, String sequence) {
    String str = new String(chars);
    return str.equals(sequence);
  }

  private static void roll(char[] chars) {
    if (chars.length == 1) {
      return;
    }
    for (int i = 1; i < chars.length; i++) {
      chars[i - 1] = chars[i];
    }
  }
}
