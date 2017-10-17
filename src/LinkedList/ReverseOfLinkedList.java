package LinkedList;

public class ReverseOfLinkedList
{
  private LLNode recurHead = null;
  public LLNode reverseLL(LLNode head)
  {
    LLNode curr = head;
    LLNode prev = null;
    LLNode next = null;

    while(curr != null)
    {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;

    return head;
  }

  public LLNode reverseLLRecursive(LLNode curr, LLNode prev)
  {
    if (curr.next == null) {
      curr.next = prev;
      recurHead = curr;
      return null;
    }

    LLNode actualNext = curr.next;
    curr.next = prev;

    reverseLLRecursive(actualNext,curr);

    return recurHead;
  }

  public LLNode reverseBetween(LLNode head, int m, int n) {
//    int diff = n - m;
//    LLNode p1 = head;
//    LLNode p2 = null;
//    LLNode prevf = null;
//    LLNode nextf;
//    for(int i = 1; i < m; i++){
//      prevf = p1;
//      p1 = p1.next;
//    }
//    p2 = p1;
//    for(int i = 0; i < diff; i++){
//      p2=p2.next;
//    }
//    nextf = p2.next;
//
//    p2.next = null;
//
//    LLNode tempCurr = p1;
//    LLNode tempPrev = null;
//    LLNode tempNext;
//    while(tempCurr != null)
//    {
//      tempNext = tempCurr.next;
//      tempCurr.next = tempPrev;
//      tempPrev = tempCurr;
//      tempCurr = tempNext;
//    }
//
//    if(prevf != null)
//    prevf.next = p2;
//
//    p1.next = nextf;

    return head;
  }

  public static void main(String[] args) {
    ReverseOfLinkedList obj = new ReverseOfLinkedList();
    LLNode objLL = new LLNode(5);
    objLL.addToLList(3);
//    objLL.addToLList(6);
//    objLL.addToLList(7);
//    objLL.addToLList(8);

    //System.out.println(obj.reverseLL(objLL));
    //System.out.println(obj.reverseLLRecursive(objLL,null));
    System.out.println(obj.reverseBetween(objLL,1,2));
  }
}
