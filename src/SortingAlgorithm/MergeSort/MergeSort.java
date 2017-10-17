package SortingAlgorithm.MergeSort;

//import java.util.Arrays;

import SortingAlgorithm.BaseSort;

public class MergeSort extends BaseSort
{
  public MergeSort(int [] arr)
  {
    super(arr);
  }

  @Override
  public void sortArray()
  {
    int sizeOfTheArray = arrayToBeSorted.length;
    int midOfArray = sizeOfTheArray/2;
    int[] leftArray;
    int[] rightArray;

    if (sizeOfTheArray < 2)
    {
      return;
    } else {
      if (sizeOfTheArray%2 == 0)
      {
        leftArray = new int[midOfArray];
        rightArray = new int[midOfArray];
      } else {
        leftArray = new int[midOfArray];
        rightArray = new int[midOfArray + 1];
      }
    }

    for (int i = 0; i < midOfArray; i++) {
      leftArray[i] = arrayToBeSorted[i];
    }

    for (int i = midOfArray; i < sizeOfTheArray; i++) {
      rightArray[i-midOfArray] = arrayToBeSorted[i];
    }

    new MergeSort(leftArray).sortArray();
    new MergeSort(rightArray).sortArray();
    //System.out.println(Arrays.toString(leftArray));
    //System.out.println(Arrays.toString(rightArray));
    //System.out.println(Arrays.toString(arrayToBeSorted));
    Merge(leftArray, rightArray, arrayToBeSorted);
  }

  private void Merge(int[] leftArray, int[] rightArray, int[] arrayToBeSorted)
  {
    int sizeOfLeftArray = leftArray.length;
    int sizeOfRightArray = rightArray.length;
    int i,j,k;
    i = j = k = 0;

    while ((i < sizeOfLeftArray) && (j < sizeOfRightArray))
    {
      if (leftArray[i] < rightArray[j]) {
        arrayToBeSorted[k] = leftArray[i];
        i++;
      } else {
        arrayToBeSorted[k] = rightArray[j];
        j++;
      }
      k++;
    }

    while (i < sizeOfLeftArray)
    {
      arrayToBeSorted[k] = leftArray[i];
      i++;
      k++;
    }

    while (j < sizeOfRightArray)
    {
      arrayToBeSorted[k] = rightArray[j];
      j++;
      k++;
    }
  }
}
