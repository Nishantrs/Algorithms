package LinkedList.CTCLinkedList;

import LinkedList.LLNode;

public class SumOfLists
{
  LLNode result = new LLNode(0);

  public LLNode findSumListReverse(LLNode l1, LLNode l2)
  {
    LLNode num1 = l1;
    LLNode num2 = l2;
    //System.out.println(num1);
    //System.out.println(num2);
    int carry = 0;
    while (num1 != null && num2 != null)
    {
      carry = addNumbers(num1.data, num2.data, carry);
      //System.out.println("In here");
      num1 = num1.next;
      num2 = num2.next;
    }

    while (num1!= null)
    {
      carry = addNumbers(num1.data,0,carry);
      num1 = num1.next;
    }

    while (num2 != null)
    {
      carry = addNumbers(0,num2.data,carry);
      num2 = num2.next;
    }

    if (carry != 0)
    {
      result.addToLList(carry);
    }

    return result.next;
  }

  private int addNumbers(int val1, int val2, int carry)
  {
    int value = val1 + val2 + carry;
    result.addToLList(value%10);
    //System.out.println(value/10);
    return value/10;
  }

  public static void main(String[] args) {
  SumOfLists obj = new SumOfLists();

    LLNode objLL = new LLNode(9);
    objLL.addToLList(9);
    objLL.addToLList(9);
    objLL.addToLList(9);

    LLNode objLL2 = new LLNode(9);
    objLL2.addToLList(9);
    objLL2.addToLList(9);
    //objLL2.addToLList(9);
    //System.out.println(obj.findSumListReverse(objLL,objLL2));
  }

}
