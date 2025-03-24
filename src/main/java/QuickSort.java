import java.util.Arrays;
import java.util.Random;

public class QuickSort<T extends  Comparable<T>> {
    T[] array;
    public QuickSort(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }
    public T[] getArray() {
        return array;
    }
    public void quickSortArray(int first, int last) {
        if (first < last) {
            int pivotElementIndex = partition(first, last);
            quickSortArray(first, pivotElementIndex - 1);
            quickSortArray(pivotElementIndex + 1, last);
        }
    }

    public void quickSortForStatistic(int first, int last, int k) {
        if (first < last) {
            int pivotElementIndex = partition(first, last);
            if(k <= pivotElementIndex) {
                quickSortForStatistic(first, pivotElementIndex, k);
            } else {
                quickSortForStatistic(pivotElementIndex + 1, last, k);
            }
        }
    }

    private int partition(int first, int last) {
//        int pivotElementIndex = (first+last)/2;
        int pivotElementIndex = first + new Random().nextInt(last-first);
        swap(pivotElementIndex, last);

        T pivotElement = array[last];
        //index that pointing to the last element is less that pivot
        int i = first - 1;
        for(int j = first; j < last; j++) {
            if(array[j].compareTo(pivotElement) <= 0) {
                if(i != j){
                    swap(++i, j);
                }
            }
        }
        swap(i+1, last);
        return i + 1;
//        return i;
    }



    private void swap (int i, int j) {
        T firstElement = array[i];
        array[i]=array[j];
        array[j] = firstElement;
    }
}
