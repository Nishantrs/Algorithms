package LinkedList.CTCLinkedList;

import java.util.HashSet;

import LinkedList.LLNode;

public class RemoveDuplicates
{
    public LLNode removeDuplicatesWithBuffer(LLNode node)
    {
      LLNode currentNode = node;
      LLNode previousNode = null;
      HashSet<Integer> uniqueIntegers = new HashSet<>();
       while(currentNode != null)
       {
         if(uniqueIntegers.contains(currentNode.data)) {
           previousNode.next = currentNode.next;
         } else {
           uniqueIntegers.add(currentNode.data);
           previousNode = currentNode;
         }
         currentNode = currentNode.next;
       }
      return node;
    }

  public LLNode removeDuplicatesWithoutBuffer(LLNode node)
  {
    LLNode currentNode = node;
    LLNode previousNode = null;

    while(currentNode != null)
    {
      LLNode pointerNode = currentNode.next;
      previousNode = currentNode;
      while(pointerNode != null)
      {
        if(currentNode.data == pointerNode.data) {
          previousNode.next = pointerNode.next;
        } else {
          previousNode = pointerNode;
        }
        pointerNode = pointerNode.next;
      }
      currentNode = currentNode.next;
    }

    return node;
  }

  public static void main(String[] args) {
    LLNode obj = new LLNode(5);
    obj.addToLList(3);
    obj.addToLList(6);
    obj.addToLList(6);
    RemoveDuplicates objUnique = new RemoveDuplicates();
    System.out.println(objUnique.removeDuplicatesWithBuffer(obj));
    obj.addToLList(6);
    System.out.println(obj);
    System.out.println(objUnique.removeDuplicatesWithoutBuffer(obj));
  }
}
