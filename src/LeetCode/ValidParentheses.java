package LeetCode;

import java.util.Stack;

public class ValidParentheses
{
  public boolean isValid(String s) {
    Stack container = new Stack();

    for (int i = 0; i < s.length(); i++) {
      char bracket = s.charAt(i);

      switch (bracket) {
        case '}':
          if (container.isEmpty() || !container.pop().equals('{')) {
            return false;
          }
          break;
        case ']':
          if (container.isEmpty() || !container.pop().equals('[')) {
            return false;
          }
          break;
        case ')':
          if (container.isEmpty() || !container.pop().equals('(')) {
            return false;
          }
          break;
        default:
          container.push(bracket);
      }
    }

    if (container.isEmpty()) {
      return true;
    }

    return false;
  }
}
