package SortingAlgorithm;

import java.util.Arrays;

public abstract class BaseSort
{
  protected int[] arrayToBeSorted;

  public BaseSort(int[] arr)
  {
    arrayToBeSorted = arr;
  }

  protected void display(boolean isAscending)
  {
    if(isAscending) {
      System.out.println(Arrays.toString(arrayToBeSorted));
    } else {
      int j = 0;
      for (int i = arrayToBeSorted.length -1; i >= j; i--)
      {
        int temp = arrayToBeSorted[i];
        arrayToBeSorted[i] = arrayToBeSorted[j];
        arrayToBeSorted[j] = temp;

        j++;
      }
      System.out.println(Arrays.toString(arrayToBeSorted));
    }
  }

  public abstract void sortArray();
}
