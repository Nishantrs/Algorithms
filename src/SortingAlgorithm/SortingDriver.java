package SortingAlgorithm;

import java.util.Arrays;

import SortingAlgorithm.BubbleSort.BubbleSort;
import SortingAlgorithm.HeapSort.HeapSort;
import SortingAlgorithm.InsertionSort.InsertionSort;
import SortingAlgorithm.MergeSort.MergeSort;
import SortingAlgorithm.QuickSort.QuickSort;
import SortingAlgorithm.SelectionSort.SelectionSort;

/**
 * Created by NishantRatnakar on 9/4/2017.
 */
public class SortingDriver
{
  public static void main(String[] args)
  {
    BubbleSort bs = new BubbleSort(new int[]{6,5,4,3,2,1});
    bs.sortArray();
    //bs.display(true);
    //bs.display(false);

    SelectionSort ss = new SelectionSort(new int[]{5,4,3,2,1});
    ss.sortArray();
    //ss.display(true);
    //ss.display(false);

    InsertionSort is = new InsertionSort(new int[]{5,4,3,2,5});
    //is.sortArray();
    //is.display(true);

    MergeSort ms = new MergeSort(new int[]{5,3,4,-6,1,2});
    //ms.sortArray();
    //ms.display(true);

    HeapSort hs = new HeapSort(new int[]{5,3,4,-6,1,2});
    //hs.sortArray();
    //hs.display(true);

    QuickSort qs = new QuickSort(new int[]{5,3,4,-6,1,2});
    //qs.sortArray();
    //qs.display(true);

    int d = 'A';
    boolean[] a = new boolean[2];
    System.out.println(Arrays.toString(a));
  }
}
