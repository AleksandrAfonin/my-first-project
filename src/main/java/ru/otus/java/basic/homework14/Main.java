package ru.otus.java.basic.homework14;


public class Main {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Wait");
    oneThread();
    fourThreads();
  }

  public static void oneThread() {
    double[] array = new double[100_000_000];
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < array.length; i++) {
      array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }
    System.out.println("Execution time in one thread: " +
            (System.currentTimeMillis() - startTime) +
            " millis");
  }

  public static void fourThreads() throws InterruptedException {
    double[] array = new double[100_000_000];
    int section = array.length / 4;
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < section; i++) {
          array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
      }
    });

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = section; i < section * 2; i++) {
          array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
      }
    });

    Thread thread3 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = section * 2; i < section * 3; i++) {
          array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
      }
    });

    Thread thread4 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = section * 3; i < array.length; i++) {
          array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
      }
    });

    long start = System.currentTimeMillis();
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    thread1.join();
    thread2.join();
    thread3.join();
    thread4.join();

    System.out.println("Execution time in four threads: " +
            (System.currentTimeMillis() - start) +
            " millis");
  }
}
