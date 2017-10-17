package LinkedList;


public class LLNode
{
  public int data;
  public LLNode next;

  public LLNode(int value)
  {
    data = value;
  }

  public void addToLList(int value)
  {
    LLNode nodeToBeAdded = new LLNode(value);
    LLNode head = this;
    LLNode currentNode = head;

    while(currentNode.next != null)
    {
      currentNode = currentNode.next;
    }
    currentNode.next = nodeToBeAdded;
  }

  // Shallow delete if head to be removed
  // unless proper association performed
  public LLNode removeFromLList(int value)
  {
    LLNode head = this;
    LLNode currentNode = head;
    LLNode previousNode = null;

    if(head.data == value) {
      return head.next;
    }

    while(currentNode.next != null)
    {
      if(currentNode.data == value) {
        previousNode.next = currentNode.next;
      }
      previousNode = currentNode;
      currentNode = currentNode.next;
    }

    if(currentNode.data == value)
    {
      previousNode.next = null;
    }
    return head;
  }

  @Override
  public String toString()
  {
    LLNode currentNode = this;
    System.out.print("["+currentNode.data+"]");
    while(currentNode.next != null)
    {
      System.out.print("["+currentNode.next.data+"]");
      currentNode = currentNode.next;
    }
    System.out.println();
    return null;
  }

  public static void main(String[] args) {
    LLNode obj = new LLNode(5);
    obj.addToLList(3);
    obj.addToLList(6);
    System.out.println(obj);
    //proper association required
    obj = obj.removeFromLList(5);
    System.out.println(obj);
    System.out.println(obj.removeFromLList(6));
  }
}
