package ru.otus.java.basic.homework11.redblacktree;

public class MyObject implements Comparable<MyObject> {
  private String name;

  public MyObject(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(MyObject o) {
    return this.name.compareTo(o.name);
  }

  @Override
  public String toString() {
    return name;
  }
}
