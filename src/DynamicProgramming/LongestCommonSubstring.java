package DynamicProgramming;

public class LongestCommonSubstring
{
  public int LCSubstring(String word0, String word1)
  {
    int word0Xword1[][] = new int[word0.length()+1][word1.length()+1];
    int maxValue = 0;
    for(int i = 1; i <= word0.length(); i++)
    {
      for(int j = 1; j <= word1.length(); j++)
      {
        if(word0Xword1[i-1]==word0Xword1[j-1]) {
          word0Xword1[i][j] = 1+word0Xword1[i-1][j-1];
          if(word0Xword1[i][j] > maxValue) {
            maxValue = word0Xword1[i][j];
          }
        }

      }
    }
    return maxValue;
  }
}
