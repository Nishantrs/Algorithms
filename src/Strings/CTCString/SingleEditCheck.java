package Strings.CTCString;

public class SingleEditCheck
{
  public boolean isOneEditAway(String word1, String word2)
  {
    if (word1.length() == word2.length())
    {
      return isOneWordReplace(word1, word2);
    } else {
      if (word1.length() > word2.length()) {
        return isOneWordEdit(word1, word2);
      } else {
        return isOneWordEdit(word2, word1);
      }
    }
  }

  private boolean isOneWordReplace(String word1, String word2)
  {
    boolean isDifferenceFound = false;
    for (int i = 0; i < word1.length(); i++)
    {
      if (word1.charAt(i) != word2.charAt(i)) {
        if (isDifferenceFound) {
          return false;
        }
        isDifferenceFound = true;
      }
    }
    return true;
  }

  private boolean isOneWordEdit(String word1, String word2)
  {
    boolean isDifferenceFound = false;
    if (word1.length() - word2.length() > 1) {
      return false;
    }
    int j=0;

    // With while loop we can reduce the number of
    // n in O(n) to smaller string
    for (int i = 0; i < word1.length(); i++)
    {
      if ( j < word2.length() && (word1.charAt(i) != word2.charAt(j))) {
        if (isDifferenceFound) {
          return false;
        }
        isDifferenceFound = true;
        continue;
      }
      j++;
    }
    return true;
  }
}
