package LeetCode;

import LinkedList.LLNode;

public class SortedArraysCombine {
  public LLNode mergeTwoLists(LLNode l1, LLNode l2) {
    LLNode dummy = new LLNode(0);
    LLNode movingPointer = dummy;
    boolean isAscending = true;

    if(l1 == null && l2 == null)
      return null;

    if (l1 != null && l1.next != null && l1.data > l1.next.data)
      isAscending = false;

    while(l1 != null && l2 != null)
    {
      if(l1.data < l2.data) {
        if (isAscending) {
          movingPointer.next = new LLNode(l1.data);
          movingPointer = movingPointer.next;
          l1 = l1.next;
        } else {
          movingPointer.next = new LLNode(l2.data);
          movingPointer = movingPointer.next;
          l2 = l2.next;
        }
      } else if (l2.data < l1.data) {
        if (isAscending) {
          movingPointer.next = new LLNode(l2.data);
          movingPointer = movingPointer.next;
          l2 = l2.next;
        } else {
          movingPointer.next = new LLNode(l1.data);
          movingPointer = movingPointer.next;
          l1 = l1.next;
        }
      } else {
        movingPointer.next = new LLNode(l1.data);
        movingPointer = movingPointer.next;
        movingPointer.next = new LLNode(l1.data);
        movingPointer = movingPointer.next;
        l1 = l1.next;
        l2 = l2.next;
      }
    }

    while(l1 != null)
    {
      movingPointer.next = new LLNode(l1.data);
      movingPointer = movingPointer.next;
      l1 = l1.next;
    }

    while(l2 != null)
    {
      movingPointer.next = new LLNode(l2.data);
      movingPointer = movingPointer.next;
      l2 = l2.next;
    }

    return dummy.next;
  }
}
