package SortingAlgorithm.SelectionSort;

import SortingAlgorithm.BaseSort;

public class SelectionSort extends BaseSort
{
  public SelectionSort(int[] arr)
  {
    super(arr);
  }

  @Override
  public void sortArray()
  {
    int sizeOfTheArray = arrayToBeSorted.length;
    int startingPoint = 0;
    int endingPoint = sizeOfTheArray - 1;
    int numberOfElementsSorted = 0;

    do
    {
      int smallestInteger = Integer.MAX_VALUE;
      int smallestIntegerPosition = Integer.MIN_VALUE;
      for (int i = startingPoint; i <= endingPoint; i++)
      {
        if (arrayToBeSorted[i] < smallestInteger) {
          smallestInteger = arrayToBeSorted[i];
          smallestIntegerPosition = i;
        }
      }
      int temp = arrayToBeSorted[startingPoint];
      arrayToBeSorted[startingPoint] = smallestInteger;
      arrayToBeSorted[smallestIntegerPosition] = temp;
      startingPoint++;
      numberOfElementsSorted++;
    } while (numberOfElementsSorted < sizeOfTheArray);
  }
}
