package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence
{
  // String should be positive number, case sensitive words
  // No negative numbers allowed, if negative numbers required,
  // array to be passed as argument
  public int LISArray(String word)
  {
    int incSeqTracker[] = new int[word.length()];
    Arrays.fill(incSeqTracker,1);

    int solutionTracking[] = new int[word.length()];
    for(int i = 0; i < word.length(); i++)
    {
      solutionTracking[i] = i;
    }
    int maxValue = Integer.MIN_VALUE;
    int maxIndex = Integer.MIN_VALUE;

    for(int i = 1; i < word.length(); i++)
    {
      for(int j = 0; j < i; j++)
      {
        // arr[j] < arr[i]
        if(word.charAt(j) < word.charAt(i)) {
          if (incSeqTracker[j]+1 >incSeqTracker[i]) {
            //incSeqTracker[i] = incSeqTracker[j] + 1;
            solutionTracking[i] = j;
          }
          incSeqTracker[i] = Math.max(incSeqTracker[i], 1 + incSeqTracker[j]);
        }
      }
      if(incSeqTracker[i] > maxValue) {
        maxValue = incSeqTracker[i];
        maxIndex = i;
      }
    }

    int index;
    int newIndex = maxIndex;
    do {
      index = newIndex;
      System.out.print(word.charAt(index) + " ");
      newIndex = solutionTracking[index];
    }while(index != newIndex);
    System.out.println();
    return maxValue;
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
    System.out.println(obj.LISArray("4501734"));
    System.out.println(obj.LISArray("abcdef"));
  }
}
