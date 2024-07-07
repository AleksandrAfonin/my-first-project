package ru.otus.java.basic.generic;

import java.util.ArrayList;

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
    for (int i = list.size() - 1; i >= 0; i--) {
      box.add(list.get(i));
      list.remove(i);
    }
  }

  @Override
  public String toString() {
    return "Box{" +
            "list=" + list +
            '}';
  }
}
