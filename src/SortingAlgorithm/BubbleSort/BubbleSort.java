package SortingAlgorithm.BubbleSort;

import SortingAlgorithm.BaseSort;

public class BubbleSort extends BaseSort
{
  public BubbleSort(int[] arr)
  {
    super(arr);
  }

  @Override
  public void sortArray()
  {
    int sizeofArray = arrayToBeSorted.length;
    int numberOfElementsSorted = 0;
    int startingPoint = sizeofArray - 1;
    int endingPoint = 0;

    do
    {
      for (int i = startingPoint; i > endingPoint; i--)
      {
        if (arrayToBeSorted[i] < arrayToBeSorted[i-1]) {
          int temp = arrayToBeSorted[i-1];
          arrayToBeSorted[i-1] = arrayToBeSorted[i];
          arrayToBeSorted[i]=temp;
        }
      }
      endingPoint++;
      numberOfElementsSorted++;
    } while (numberOfElementsSorted < sizeofArray);
  }
}
