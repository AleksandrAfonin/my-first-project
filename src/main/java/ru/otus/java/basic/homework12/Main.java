package ru.otus.java.basic.homework12;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    FilesWorker filesWorker = new FilesWorker("files");

    String fileName = "";
    int command = 0;
    do {
      do {
        System.out.println();
        System.out.println("1 - create file and select");
        System.out.println("2 - delete selected file");
        System.out.println("3 - select file");
        System.out.println("4 - read selected file");
        System.out.println("5 - write to selected file");
        System.out.println("6 - print files list");
        System.out.println("7 - exit");
        if (scan.hasNextInt()) {
          command = scan.nextInt();
        } else {
          scan.nextLine();
        }
      } while (command < 1 || command > 7);

      scan.nextLine();
      switch (command) {
        case 1:
          System.out.print("Enter the file name: ");
          fileName = scan.nextLine();
          filesWorker.createFile(fileName);
          break;
        case 2:
          filesWorker.deleteFile(fileName);
          break;
        case 3:
          System.out.print("Enter the file name: ");
          fileName = scan.nextLine();
          filesWorker.readFile(fileName);
          break;
        case 4:
          filesWorker.readFile(fileName);
          break;
        case 5:
          if (fileName.isEmpty()) {
            System.out.println("The file is not selected");
            break;
          }
          System.out.println("Enter the text to write into the '" + fileName + "'");
          filesWorker.writeFile(fileName, scan.nextLine(), true);
          break;
        case 6:
          filesWorker.printFilesList();
          break;
      }
    } while (command != 7);
  }
}
