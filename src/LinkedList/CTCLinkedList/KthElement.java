package LinkedList.CTCLinkedList;

import LinkedList.LLNode;

public class KthElement
{
  public LLNode findKthElement(LLNode head, int k)
  {
    LLNode referenceNode = head;
    LLNode KthFromReference = referenceNode;

    while(referenceNode.next != null && k > 0)
    {
      referenceNode = referenceNode.next;
      k--;
    }

    while(referenceNode.next != null)
    {
      KthFromReference = KthFromReference.next;
      referenceNode = referenceNode.next;
    }
    return KthFromReference;
  }

  public static void main(String[] args) {
    KthElement obj = new KthElement();
    LLNode objLL = new LLNode(5);
    objLL.addToLList(3);
    objLL.addToLList(6);
    objLL.addToLList(6);

    System.out.println(obj.findKthElement(objLL,0));
  }
}
