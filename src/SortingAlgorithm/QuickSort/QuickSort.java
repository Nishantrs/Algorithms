package SortingAlgorithm.QuickSort;

import SortingAlgorithm.BaseSort;

public class QuickSort extends BaseSort
{

  public QuickSort(int[] arr)
  {
    super(arr);
  }

  int sizeOfTheArray = arrayToBeSorted.length;

  @Override
  public void sortArray()
  {
    quick(arrayToBeSorted, 0, sizeOfTheArray - 1);
  }

  private void quick(int[] arrayToBeSorted, int lowerBound, int upperBound)
  {
    int j = 0;
    if (lowerBound >= upperBound)
      return;
    j = partition(arrayToBeSorted, lowerBound, upperBound);
    quick(arrayToBeSorted, lowerBound, j-1);
    quick(arrayToBeSorted, j+1, upperBound);
  }

  // http://www.cs.armstrong.edu/liang/animation/web/QuickSortPartition.html
  private int partition(int[] arrayToBeSorted, int lowerBound, int upperBound)
  {
    int pivot, down, up, temp;

    pivot = arrayToBeSorted[lowerBound];
    down = lowerBound;
    up = upperBound;

    while (down < up)
    {
      while (arrayToBeSorted[down] <= pivot && down < upperBound)
        down++;

      while (arrayToBeSorted[up] > pivot)
        up--;

      if (down < up)
      {
        temp = arrayToBeSorted[down];
        arrayToBeSorted[down] = arrayToBeSorted[up];
        arrayToBeSorted[up] = temp;
      }
    }
    arrayToBeSorted[lowerBound] = arrayToBeSorted[up];
    arrayToBeSorted[up] = pivot;
    return up;
  }

}
