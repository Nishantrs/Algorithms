package Strings.CTCString;

public class RotatedPermutationCheck
{
  public boolean isRotatedPermutation(String word1,String word2)
  {
    if ((word1.length() == word2.length()) && (word1.length() > 0)) {
      return isSubstring(word1 + word1, word2);
    }
    return false;
  }

  private boolean isSubstring(String word1, String word2)
  {
    boolean hasMatchBegan = false;
    int j = 0;
    for (int i=0; i < word1.length(); i++)
    {
      if (j < word2.length() && word1.charAt(i) != word2.charAt(j)) {
        if (hasMatchBegan) {
          return false;
        }
        continue;
      }
      hasMatchBegan = true;
      j++;
    }
    return true;
  }
}
