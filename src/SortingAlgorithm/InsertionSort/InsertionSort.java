package SortingAlgorithm.InsertionSort;

import SortingAlgorithm.BaseSort;

public class InsertionSort extends BaseSort
{
  public InsertionSort(int[] arr)
  {
    super(arr);
  }

  @Override
  public void sortArray()
  {
    int sizeOfTheArray = arrayToBeSorted.length;
    int endingPoint;
    int startingPoint = 0;

    for (int i = startingPoint; i <= sizeOfTheArray - 1; i++)
    {
      endingPoint = i;
      while (startingPoint < endingPoint)
      {
         if (arrayToBeSorted[endingPoint - 1] <= arrayToBeSorted[endingPoint]) {
           break;
         }
        int temp = arrayToBeSorted[endingPoint];
        arrayToBeSorted[endingPoint] = arrayToBeSorted[endingPoint - 1];
        arrayToBeSorted[endingPoint - 1] = temp;
        endingPoint--;
      }
    }
  }
}
