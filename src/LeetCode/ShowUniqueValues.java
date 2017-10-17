package LeetCode;

import java.util.Arrays;

public class ShowUniqueValues
{
  public int removeDuplicates(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }

    int uniqueindex = 0;

    for(int i=1; i < nums.length; i++)
    {
      if(nums[uniqueindex] != nums[i]) {
        uniqueindex++;
        nums[uniqueindex] = nums[i];
      }
    }
    return ++uniqueindex;

//    int uniqueindex = 0;
//    int previousValue = 0;
//
//    if(nums == null) {
//      return 0;
//    }
//
//    for(int i=0; i < nums.length; i++)
//    {
//      if(nums[i] == previousValue && i != 0) {
//        continue;
//      }
//
//      nums[uniqueindex] = nums[i];
//      uniqueindex++;
//      previousValue = nums[i];
//    }
//
//    return uniqueindex++;
  }

  public static void main(String[] args) {
    ShowUniqueValues obj = new ShowUniqueValues();
    int[] arr1  = new int[]{1};
    int[] arr2  = new int[]{1,1,2,3};
    int[] arr3  = new int[]{1,2,3,3,3,4};

    System.out.println(obj.removeDuplicates(arr2));
    System.out.println(Arrays.toString(arr2));
  }
}
