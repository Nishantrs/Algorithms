package BinarySearchTree;

/**
 * Created by NishantRatnakar on 9/17/2016.
 */


public class Node {

  Node leftChild;
  Node rightChild;
  int data;

  public Node(int data){
    super();
    this.data = data;
  }


  public Node getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
  }

  public Node getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}
