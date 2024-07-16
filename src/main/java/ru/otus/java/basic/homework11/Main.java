package ru.otus.java.basic.homework11;

import ru.otus.java.basic.homework11.redblacktree.MyObject;

public class Main {

  public static void main(String[] args) {
    Tree<MyObject> myTree = new Tree<>();

    for (int i = 1; i <= 9; i++) {
      myTree.insert(new MyObject("name" + i));
    }

    System.out.println("Tree structure:");
    myTree.printTree();
    System.out.println();
    System.out.println("min: " + myTree.getMin());
    System.out.println("max: " + myTree.getMax());

    System.out.println("item 'name1': " + myTree.getItem("name1"));
  }
}
