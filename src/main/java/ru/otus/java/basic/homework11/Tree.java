package ru.otus.java.basic.homework11;

public class Tree<T extends Comparable<T>> {
  private Node<T> root;

  public void insert(T data) {
    Node<T> node = new Node<>(data);
    root = insert(root, node);
    recolorAndRotate(node);
  }

  private Node<T> insert(Node<T> node, Node<T> nodeToInsert) {
    if (node == null) {
      return nodeToInsert;
    }
    if (nodeToInsert.getData().compareTo(node.getData()) < 0) {
      node.setLeftChild(insert(node.getLeftChild(), nodeToInsert));
      node.getLeftChild().setParent(node);
    } else if (nodeToInsert.getData().compareTo(node.getData()) > 0) {
      node.setRightChild(insert(node.getRightChild(), nodeToInsert));
      node.getRightChild().setParent(node);
    }
    return node;
  }

  private void recolorAndRotate(Node<T> node) {
    Node<T> parent = node.getParent();
    if (parent != null && parent.getColor() == Color.RED) {// Если не корень и родитель красный
      Node<T> grandParent = node.getParent().getParent();
      Node<T> uncle = parent.isLeftChild() ?
              (grandParent == null ? null : grandParent.getRightChild())
              : (grandParent == null ? null : grandParent.getLeftChild());
      if (uncle != null && uncle.getColor() == Color.RED) {
        handleRecoloring(parent, uncle, grandParent);
      } else if (parent.isLeftChild()) {
        handleLeftSituations(node, parent, grandParent);
      } else if (!parent.isLeftChild()) {
        handleRightSituations(node, parent, grandParent);
      }
    }
    root.setColor(Color.BLACK);
  }

  private void rotateRight(Node<T> node) {
    Node<T> leftNode = node.getLeftChild();
    node.setLeftChild(leftNode.getRightChild());
    if (node.getLeftChild() != null) {
      node.getLeftChild().setParent(node);
    }
    leftNode.setRightChild(node);
    leftNode.setParent(node.getParent());
    updateChildrenOfParentNode(node, leftNode);
    node.setParent(leftNode);
  }

  private void rotateLeft(Node<T> node) {
    Node<T> rightNode = node.getRightChild();
    node.setRightChild(rightNode.getLeftChild());
    if (node.getRightChild() != null) {
      node.getRightChild().setParent(node);
    }
    rightNode.setLeftChild(node);
    rightNode.setParent(node.getParent());
    updateChildrenOfParentNode(node, rightNode);
    node.setParent(rightNode);
  }

  private void updateChildrenOfParentNode(Node<T> node, Node<T> tempNode) {
    if (node.getParent() == null) {
      root = tempNode;
    } else if (node.isLeftChild()) {
      node.getParent().setLeftChild(tempNode);
    } else {
      node.getParent().setRightChild(tempNode);
    }
  }

  private void handleRightSituations(Node<T> node,
                                     Node<T> parent,
                                     Node<T> grandParent) {
    if (node.isLeftChild()) {
      rotateRight(parent);
    }
    parent.flipColor();
    if (grandParent != null) {
      grandParent.flipColor();
      rotateLeft(grandParent);
    }
    recolorAndRotate(node.isLeftChild() ? grandParent : parent);
  }

  private void handleLeftSituations(Node<T> node,
                                    Node<T> parent,
                                    Node<T> grandParent) {
    if (!node.isLeftChild()) {
      rotateLeft(parent);
    }
    parent.flipColor();
    grandParent.flipColor();
    rotateRight(grandParent);
    recolorAndRotate(node.isLeftChild() ? parent : grandParent);
  }

  private void handleRecoloring(Node<T> parent,
                                Node<T> uncle,
                                Node<T> grandParent) {
    uncle.flipColor();
    parent.flipColor();
    grandParent.flipColor();
    recolorAndRotate(grandParent);
  }

  public void printTree() {
    if (this.root == null) {
      return;
    }
    System.out.println(root.getData() + "(" + root.getColor() + ")");
    printHelper(this.root.getLeftChild(), "", false);
    printHelper(this.root.getRightChild(), "", true);
  }

  private void printHelper(Node<T> root, String indent, boolean last) {
    if (root != null) {
      System.out.print(indent);
      if (last) {
        System.out.print("R----");
        indent += "     ";
      } else {
        System.out.print("L----");
        indent += "|    ";
      }
      System.out.println(root.getData() + "(" + root.getColor() + ")");
      printHelper(root.getLeftChild(), indent, false);
      printHelper(root.getRightChild(), indent, true);
    }
  }

  public Node<T> getMin() {
    if (this.root == null) {
      return null;
    }
    return min(this.root);
  }

  private Node<T> min(Node<T> node) {
    if (node.getLeftChild() == null) {
      return node;
    }
    return min(node.getLeftChild());
  }

  public Node<T> getMax() {
    if (this.root == null) {
      return null;
    }
    return max(this.root);
  }

  private Node<T> max(Node<T> node) {
    if (node.getRightChild() == null) {
      return node;
    }
    return max(node.getRightChild());
  }

  public Node<T> getItem(String key){
    return searchItem(this.root, key);
  }

  private Node<T> searchItem(Node<T> node, String key){
    if (node == null || node.getData().toString().equals(key)) {
      return node;
    }

    if (node.getData().toString().compareTo(key) > 0) {
      return searchItem(node.getLeftChild(), key);
    }
    return searchItem(node.getRightChild(), key);
  }
}
