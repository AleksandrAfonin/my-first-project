package ru.otus.java.basic.iopart2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    String[] items;
    try (Scanner scanner = new Scanner(System.in)) {
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
    }
    int count = countingSequence(items[0], items[1]);
    if (count != -1) {
      System.out.println("In the '" + items[0] + "' file, the sequence is repeated " + count + " times");
    }
  }

  public static int countingSequence(String fileName, String sequence) {
    if (sequence.isEmpty()) {
      return 0;
    }
    StringBuilder buffer = new StringBuilder();
    buffer.append(" ".repeat(sequence.length()));
    int count = 0;

    try (FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8)) {
      int c;
      while ((c = fileReader.read()) != -1) {
        roll(buffer);
        buffer.append((char) c);
        if (compareSequence(buffer, sequence)) {
          count++;
        }
      }
      return count;
    } catch (FileNotFoundException e) {
      System.out.println("The file '" + fileName + "' is not found");
      return -1;
    } catch (IOException e) {
      System.out.println("I/O error");
      return -1;
    }
  }

  private static boolean compareSequence(StringBuilder buffer, String sequence) {
    return buffer.toString().equals(sequence);
  }

  private static void roll(StringBuilder buffer) {
    if (buffer.length() > 1) {
      buffer.deleteCharAt(0);
    }
  }
}
