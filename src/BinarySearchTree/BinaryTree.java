package BinarySearchTree;

/**
 * Created by NishantRatnakar on 9/17/2016.
 */
public class BinaryTree {

  private Node root;

  public void insertToTree(int data){

    Node newNode = new Node(data);

    if (root == null){
      root = newNode;
    }else {

      Node current = root;

      while(current != null){

        if(newNode.getData() > current.getData()){
          if(current.getRightChild() == null){
            current.setRightChild(newNode);
            break;
          }else{
            current = current.getRightChild();
          }
        }else if (newNode.getData() < current.getData()){
          if(current.getLeftChild() == null){
            current.setLeftChild(newNode);
            break;
          }else{
            current = current.getLeftChild();
          }
        }
      }
    }

  }

  public void preOrderTraversal(Node root){
    //this.root = root;

    if (root == null){
      return;
    }
      System.out.println(root.getData());
      preOrderTraversal(root.getLeftChild());
      preOrderTraversal(root.getRightChild());

  }

  public void postOrderTraversal(Node root){
    //this.root = root;

    if (root == null){
      return;
    }

      postOrderTraversal(root.getLeftChild());
      postOrderTraversal(root.getRightChild());
      System.out.println(root.getData());

  }

  public void inOrderTraversal(Node root){
    //this.root = root;

    if (root == null){
      return;
    }

    inOrderTraversal(root.getLeftChild());
    System.out.println(root.getData());
    inOrderTraversal(root.getRightChild());


  }

  public void deleteNodeTree(Node root){

  }

  public static void main(String[] args) {

    BinaryTree treeObj = new BinaryTree();

    treeObj.insertToTree(2);
    treeObj.insertToTree(1);
    treeObj.insertToTree(3);
    treeObj.insertToTree(5);
    treeObj.insertToTree(4);
    treeObj.insertToTree(6);

    treeObj.preOrderTraversal(treeObj.root);
  }
}
