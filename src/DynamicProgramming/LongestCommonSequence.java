package DynamicProgramming;

public class LongestCommonSequence
{
  public int LCSequenceMaxValue(String word0,String word1)
  {
    int word0Xword1[][] = new int[word0.length()+1][word1.length()+1];

    for(int i = 1; i <= word0.length(); i++)
    {
      for(int j = 1; j <= word1.length(); j++)
      {
        // No other conditions to be check as in
        // common sequence
        if(word0.charAt(i-1) == word1.charAt(j-1)) {
          word0Xword1[i][j] = word0Xword1[i-1][j-1] + 1;
        } else {
          word0Xword1[i][j] = Math.max(word0Xword1[i-1][j], word0Xword1[i][j-1]);
        }
      }
    }
    return word0Xword1[word0.length()][word1.length()];
  }

  public int LCSequenceRecursive(String word0,String word1,int index0,int index1)
  {
    if(word0.length() == index0 || word1.length() == index1) {
      return 0;
    }

    if(word0.charAt(index0) == word1.charAt(index1)) {
      return 1+LCSequenceRecursive(word0,word1,index0+1,index1+1);
    } else {
      return Math.max(LCSequenceRecursive(word0,word1,index0+1,index1),LCSequenceRecursive(word0,word1,index0,index1+1));
    }
  }

  public static void main(String[] args) {
    LongestCommonSequence obj = new LongestCommonSequence();
    System.out.println(obj.LCSequenceMaxValue("abcdaf","acbcf"));
    System.out.println(obj.LCSequenceRecursive("abcdaf","acbcf",0,0));
  }
}
