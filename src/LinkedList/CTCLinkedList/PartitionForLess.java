package LinkedList.CTCLinkedList;

import LinkedList.LLNode;

public class PartitionForLess
{
  public LLNode partition(LLNode head, int partitionValue)
  {
    LLNode currentNode = head;
    LLNode lowerValueSequence = new LLNode(partitionValue);
    LLNode lowerValueEndPointer = lowerValueSequence;
    LLNode higherValueSequence = new LLNode(partitionValue);
    while(currentNode != null)
    {
      if(currentNode.data < partitionValue)
      {
        lowerValueSequence.addToLList(currentNode.data);
        lowerValueEndPointer = lowerValueEndPointer.next;
      } else {
        higherValueSequence.addToLList(currentNode.data);
      }
      currentNode = currentNode.next;
    }

    lowerValueSequence = lowerValueSequence.next;
    higherValueSequence = higherValueSequence.next;

    lowerValueEndPointer.next = higherValueSequence;

    return lowerValueSequence;
  }

  public static void main(String[] args) {

    PartitionForLess obj = new PartitionForLess();
    LLNode objLL = new LLNode(5);
    objLL.addToLList(3);
    objLL.addToLList(6);
    objLL.addToLList(7);
    objLL.addToLList(1);
    objLL.addToLList(2);
    objLL.addToLList(4);
    objLL.addToLList(8);

    System.out.println(obj.partition(objLL,5));
    }
}
