package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SumArray
{
  // brute force
  public int[] twoSum(int[] nums, int target) {
    int[] solution = new int[2];

    for(int i = 0;i < nums.length;i++)
    {
      solution[0] = i;
      int remaining = target - nums[i];
      for(int j = i+1;j < nums.length;j++)
      {
        if(nums[j] > remaining | nums[j] < remaining)
        {
          continue;
        }
        solution[1] = j;
        return solution;
      }
    }
    return solution;
  }

  public int[] twoSumHashMap(int[] nums, int target) {
    int[] solution = new int[2];
    Map<Integer, Integer> tracker = new HashMap<>();
    for(int i = 0;i < nums.length;i++)
    {
      solution[1] = i;
      if(tracker.containsKey(nums[i])) {
        solution[0] = tracker.get(nums[i]);
        // save iterations
        return solution;
      }
      int remaining = target - nums[i];
      tracker.put(remaining,i);
    }
    return solution;
  }
}
