package ru.otus.java.basic.homework13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private static ServerSocket serverSocket;
  private static DataInputStream in;
  private static DataOutputStream out;

  private static Double firstNumber;
  private static Double secondNumber;
  private static char operation;

  public static void main(String[] args) throws IOException {
    serverSocket = new ServerSocket(8089);
    System.out.println("Server started");
    Socket client = serverSocket.accept();
    System.out.println("Server: Client connected");
    in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
    out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
    out.writeUTF("Calculator\nOperations:\n+ Sum\n- Subtraction\n* Multiplication\n/ Division\n" +
            "Enter expression:\nFor example: 2 + 2\n");
    out.flush();

    while (true) {
      String[] result = in.readUTF().trim().replaceAll("  ", " ").split(" ");
      if (result.length != 3) {
        out.writeUTF("Unknown expression");
        out.flush();
      } else {
        try {
          firstNumber = Double.parseDouble(result[0]);
          secondNumber = Double.parseDouble(result[2]);
          operation = result[1].charAt(0);
          // можно вынести в отдельный метод
          switch (operation) {
            case '+':
              out.writeUTF(String.valueOf(firstNumber + secondNumber));
              out.flush();
              break;
            case '-':
              out.writeUTF(String.valueOf(firstNumber - secondNumber));
              out.flush();
              break;
            case '*':
              out.writeUTF(String.valueOf(firstNumber * secondNumber));
              out.flush();
              break;
            case '/':
              if (secondNumber == 0) {
                out.writeUTF("ERROR ! Division by zero !");
                out.flush();
                break;
              }
              out.writeUTF(String.valueOf(firstNumber / secondNumber));
              out.flush();
              break;
            default:
              out.writeUTF("Unknown operation");
              out.flush();
          }

        } catch (NumberFormatException e) {
          out.writeUTF("Unknown number");
          out.flush();
        }
      }
    }
  }
}
