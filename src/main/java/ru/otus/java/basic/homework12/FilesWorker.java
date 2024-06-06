package ru.otus.java.basic.homework12;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FilesWorker {
  private File directory;

  public FilesWorker() {
    this.directory = new File("default");
    createDirectory();
  }

  public FilesWorker(String directory) {
    this.directory = new File(directory);
    createDirectory();
  }

  private void createDirectory() {
    if (!this.directory.exists()) {
      if (this.directory.mkdirs()) {
        System.out.println("A new directory '" + this.directory.getName() + "' created !");
      } else {
        System.out.println("Failed to created a new directory '" + this.directory.getName() + "' !");
      }
    }
  }

  public File[] getFiles() {
    return directory.listFiles();
  }

  public boolean createFile(String name) {
    if (name.isEmpty()) {
      System.out.println("File name is empty");
      return false;
    }
    // Автоматическое создание правильного пути в зависимости от ОС
    File file = new File(this.directory.getName(), name);
    if (!file.exists()) {
      try {
        if (file.createNewFile()) {
          System.out.println("A new file '" + name + "' created !");
          return true;
        } else {
          System.out.println("Failed to created a new file '" + name + "' !");
          return false;
        }
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    } else {
      System.out.println("The file '" + name + "' already exist !");
      return false;
    }
  }

  public boolean deleteFile(String name) {
    if (name.isEmpty()) {
      System.out.println("File name is empty");
      return false;
    }
    File file = new File(this.directory.getName(), name);
    if (file.exists()) {
      if (file.delete()) {
        System.out.println("The file '" + name + "' deleted !");
        return true;
      } else {
        System.out.println("Failed to deleted the file '" + name + "' !");
        return false;
      }
    } else {
      System.out.println("The file '" + name + "' is not exist !");
      return false;
    }
  }

  public void printFilesList() {
    File[] files = getFiles();
    if (files.length == 0) {
      System.out.println("There are no files in this directory");
      return;
    }
    for (File fl : files) {
      if (fl.isFile()) {
        System.out.println(fl.getName());
      }
    }
  }

  public boolean writeFile(String name, String text, boolean append) {
    if (name.isEmpty()) {
      System.out.println("File name is empty");
      return false;
    }
    File file = new File(this.directory, name);
    if (!file.exists()) {
      System.out.println("The file '" + name + "' not exist !");
      return false;
    }

    try (FileOutputStream fos = new FileOutputStream(file, append)) {
      byte[] buffer = (text + "\n").getBytes(StandardCharsets.UTF_8);
      fos.write(buffer);
    } catch (FileNotFoundException e) {
      System.out.println("The file '" + name + "' not found !");
      return false;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public boolean readFile(String name) {
    if (name.isEmpty()) {
      System.out.println("File name is empty");
      return false;
    }
    File file = new File(this.directory, name);
    if (!file.exists()) {
      System.out.println("The file '" + name + "' not exist !");
      return false;
    }

    try (InputStreamReader bis = new InputStreamReader(new FileInputStream(file))) {
      int n = bis.read();
      while (n != -1) {
        System.out.print((char) n);
        n = bis.read();
      }
    } catch (FileNotFoundException e) {
      System.out.println("The file '" + name + "' not found !");
      return false;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }
}
