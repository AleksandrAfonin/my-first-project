package ru.otus.java.basic.threadspart2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  static final Object monitor = new Object();
  static boolean printA = false;
  static boolean printB = false;
  static boolean printC = true;


  public static void main(String[] args) {
    // Как минимум 3 потока нужно назначить. Иначе ничего работать не будет.
    try (ExecutorService executorService = Executors.newScheduledThreadPool(10)) {

      executorService.execute(() -> {
        synchronized (monitor) {
          try {
            for (int i = 0; i < 5; i++) {
              while (!printC) {
                monitor.wait();
              }
              System.out.print("A");
              printA = true;
              printC = false;
              monitor.notifyAll();
            }
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      });

      executorService.execute(() -> {
        synchronized (monitor) {
          try {
            for (int i = 0; i < 5; i++) {
              while (!printA) {
                monitor.wait();
              }
              System.out.print("B");
              printB = true;
              printA = false;
              monitor.notifyAll();
            }
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      });

      executorService.execute(() -> {
        synchronized (monitor) {
          try {
            for (int i = 0; i < 5; i++) {
              while (!printB) {
                monitor.wait();
              }
              System.out.print("C");
              printC = true;
              printB = false;
              monitor.notifyAll();
            }
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      });

      executorService.shutdown();
    }
  }
}
