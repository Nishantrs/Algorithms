package Strings.CTCString;

public class PermutationCheck
{
  public boolean isPermutation(String word1, String word2)
  {
    if (word1.length() != word2.length())
      return false;

    int[] characterCount = new int[128];

    // One approach would be to sort
    // java.util.Arrays.sort(char[])

    //O(n)
    for (int i=0;i < word1.length();i++)
    {
      int asciiValue = word1.charAt(i);
      characterCount[asciiValue]++;
    }

    //O(n)
    for (int i=0;i < word2.length();i++)
    {
      int asciiValue = word2.charAt(i);
      characterCount[asciiValue]--;

      if (characterCount[asciiValue] < 0)
      {
        return false;
      }
    }
    return true;
  }
}
