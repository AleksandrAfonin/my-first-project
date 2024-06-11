package ru.otus.java.basic.homework13;

import java.net.Socket;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String userInput;
    String result;

    // также не забываем закрывать ресурсы: socket, inputStream, outputStream
    try (Socket socket = new Socket("localhost", 8089)) {
      Client client = new Client(socket);
      System.out.println("Server: " + client.read());
      System.out.println("Enter 'exit' for exit");

      while (true) {
        System.out.print("Client: ");
        userInput = scanner.nextLine();
        if (userInput.equals("exit")) {
          break;
        }
        client.send(userInput);
        result = client.read();

        System.out.println("Server: " + result);
      }
      System.out.println("Exit");
      client.closes();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
