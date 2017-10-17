package DynamicProgramming;

public class LongestPalindromicSubsequence
{
  public int LPSArray(String word)
  {
    int indexXIndex[][] = new int[word.length()][word.length()];
    int column;
    for (int i = 0; i < word.length(); i++)
    {
      indexXIndex[i][i] = 1;
    }
    for (int length = 2; length <= word.length(); length++)
    {
      // row iteration based on length
      for (int row = 0; row < word.length() - length + 1; row++)
      {
        // column iteration based on length and row
        column = row + length - 1;

        if (length == 2 & (word.charAt(row) == word.charAt(column))) {
          indexXIndex[row][column] = 2;
        } else if (word.charAt(row) == word.charAt(column)) {
          indexXIndex[row][column] = 2 + indexXIndex[row + 1][column - 1];
        } else {
          indexXIndex[row][column] = Math.max(indexXIndex[row + 1][column],
                                              indexXIndex[row][column - 1]);
        }
      }
    }
    return indexXIndex[0][word.length() - 1];
  }

  public int LPSRecursive(String word, int start, int length)
  {
    if (length == 1)
    {
      return 1;
    } else if (length == 0) {
      return 0;
    } else if (word.charAt(start) == word.charAt(start + length - 1)) {
      // Checking ends of the word, if matching trim the ends and add 2
      return 2 + LPSRecursive(word, start + 1, length - 2);
    } else {
      // "abd" -> "ab" + "bd"
      return Math.max(LPSRecursive(word, start + 1, length - 1), LPSRecursive(word, start, length - 1));
    }
  }

  public static void main(String[] args) {
    LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
    System.out.println(obj.LPSArray("abbda"));
    System.out.println(obj.LPSRecursive("abdba", 0, 5));
  }
}
