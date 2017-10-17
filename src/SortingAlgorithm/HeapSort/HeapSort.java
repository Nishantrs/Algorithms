package SortingAlgorithm.HeapSort;

import SortingAlgorithm.BaseSort;

public class HeapSort extends BaseSort
{
  public HeapSort(int[] arr)
  {
    super(arr);
  }

  int sizeOfTheArray = arrayToBeSorted.length;

  @Override
  public void sortArray()
  {
    for (int i = sizeOfTheArray/2 -1; i >= 0; i--)
      heapify(sizeOfTheArray,i);

    for (int i = sizeOfTheArray - 1; i >= 0; i--)
    {
      int temp = arrayToBeSorted[0];
      arrayToBeSorted[0] = arrayToBeSorted[i];
      arrayToBeSorted[i] = temp;

      // Eliminate the largest element computed in every
      // iteration
      heapify(i,0);
    }

  }

  private void heapify (int sizeOfTheArrayToBeHeapified, int indexOfElementToBeSorted)
  {
    int rootIndexOfLargestElement = indexOfElementToBeSorted;
    int indexOfElementToRight = 2*rootIndexOfLargestElement + 2;
    int indexOfElementToLeft = 2*rootIndexOfLargestElement + 1;

    if ((indexOfElementToLeft < sizeOfTheArrayToBeHeapified) &&
            (arrayToBeSorted[rootIndexOfLargestElement] < arrayToBeSorted[indexOfElementToLeft]))
    {
      rootIndexOfLargestElement = indexOfElementToLeft;
    }

    if ((indexOfElementToRight < sizeOfTheArrayToBeHeapified) &&
            (arrayToBeSorted[rootIndexOfLargestElement] < arrayToBeSorted[indexOfElementToRight]))
    {
      rootIndexOfLargestElement = indexOfElementToRight;
    }

    if (rootIndexOfLargestElement != indexOfElementToBeSorted)
    {
      int temp = arrayToBeSorted[rootIndexOfLargestElement];
      arrayToBeSorted[rootIndexOfLargestElement] = arrayToBeSorted[indexOfElementToBeSorted];
      arrayToBeSorted[indexOfElementToBeSorted] = temp;

      // since position of element under consideration is swapped
      // with largest
      heapify(sizeOfTheArrayToBeHeapified, rootIndexOfLargestElement);
    }
  }
}


