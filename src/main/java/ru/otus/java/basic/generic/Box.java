package ru.otus.java.basic.generic;

import java.util.ArrayList;
import java.util.Objects;

public class Box<T extends Fruit> {
  private ArrayList<T> list;

  public Box() {
    this.list = new ArrayList<>();
  }

  public void add(T fruit) {
    list.add(fruit);
  }

  public double weight() {
    double weight = 0.0;
    for (T item : list) {
      weight += item.getWeight();
    }
    return weight;
  }

  public boolean compare(Box<?> box) {
    return Math.abs(this.weight() - box.weight()) < 0.01;
  }

  public void refillingTo(Box<? super T> box) {
    if (box == null) {
      System.out.println("The receiving box does not exist");
      return;
    }
    if (this.equals(box)) {
      System.out.println("It cannot be poured into the same box");
      return;
    }

    box.list.addAll(this.list);
    this.list.clear();
  }

  @Override
  public String toString() {
    return "Box{" +
            "list=" + list +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Box<?> box = (Box<?>) o;
    return Objects.equals(list, box.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }
}
