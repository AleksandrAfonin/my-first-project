package ru.otus.java.basic.homework11;

public class Node<T extends Comparable<T>> {
  private final T data;
  private Color color;
  private Node<T> leftChild;
  private Node<T> rightChild;
  private Node<T> parent;

  public Node (T data){
    this.data = data;
    this.color = Color.RED;
  }

  public T getData() {
    return data;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Node<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node<T> leftChild) {
    this.leftChild = leftChild;
  }

  public Node<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node<T> rightChild) {
    this.rightChild = rightChild;
  }

  public Node<T> getParent() {
    return parent;
  }

  public void setParent(Node<T> parent) {
    this.parent = parent;
  }

  public boolean isLeftChild(){
    if (parent == null){
      return false;
    }
    return this == parent.getLeftChild();
  }

  public void flipColor(){
    setColor(color == Color.RED ? Color.BLACK : Color.RED);
  }


  @Override
  public String toString() {
    String str1 = data == null ? "Null" : String.valueOf(getData());
    String str2 = leftChild == null ? "Null" : String.valueOf(leftChild.getData());
    String str3 = rightChild == null ? "Null" : String.valueOf(rightChild.getData());
    String str4 = parent == null ? "Null" : String.valueOf(parent.getData());

    return "Node{" +
            "data=" + str1 +
            ", color=" + color +
            ", leftChild=" + str2 +
            ", rightChild=" + str3 +
            ", parent=" + str4 +
            '}';
  }
}
