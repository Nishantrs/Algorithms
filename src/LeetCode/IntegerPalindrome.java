package LeetCode;

public class IntegerPalindrome
{
  public boolean isPalindromeSelf(int x) {
    int original = x;
    int multiplyingInteger = 0;
    int reverse = 0;

    while(x != 0)
    {
      int lastDigit = x%10;
      reverse = multiplyingInteger*10 + lastDigit;
      multiplyingInteger = reverse;
      x = x/10;
    }

    if(original == reverse && original >= 0)
    {
      return true;
    }
    return false;
  }

  public boolean isPalindromeEfficient(int x) {
    int reverse = 0;

    if (x < 0 || (x % 10 == 0 && x != 0))
      return false;

    while (x > reverse) {
      reverse = reverse * 10 + x%10;
      x = x / 10;

      if (x == reverse || x == reverse/10)
        return true;
    }
    return false;
  }
}
