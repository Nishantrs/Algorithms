package LeetCode;

public class IntegerReverse
{
  public int reverse(int x)
  {
    int reverseValue = 0;

    while(x != 0)
    {
      int lastDigit = x%10;
      int newReverseValue = reverseValue*10 + lastDigit;
      if ((newReverseValue - lastDigit)/10 != reverseValue) {
        return 0;
      }
      reverseValue = newReverseValue;
      x = x/10;
    }
    return reverseValue;
  }
}
