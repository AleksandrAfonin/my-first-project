package ru.otus.java.basic.homework13;

import java.io.*;
import java.net.Socket;

public class Client {

  private final DataInputStream in;
  private final DataOutputStream out;

  public Client(Socket socket) throws IOException {
    this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    this.out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
  }

  public void send(String request) throws IOException {
    out.writeUTF(request);
    out.flush();
  }

  public String read() throws IOException {
    return in.readUTF();
  }

  public void closes() throws IOException {
    in.close();
    out.close();
  }

}
