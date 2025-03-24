import java.util.Arrays;

public class MergeSort<T extends Comparable<T>>{

    T[] array;

    public MergeSort(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public T[] getArray() {
        return array;
    }

    public void mergeSort () {
        mergeSortRecursive(array);
    }

    private void mergeSortRecursive(T[] array){
        if(array.length <= 1) return;
        T[] leftArray = Arrays.copyOfRange(array, 0, array.length/2);
        T[] rightArray = Arrays.copyOfRange(array, array.length/2, array.length);
        mergeSortRecursive(leftArray);
        mergeSortRecursive(rightArray);
        merge(array, leftArray, rightArray);
    }

    private void merge(T[] array, T[] leftArray, T[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        for(int i=0; i < array.length; i++) {
            if(leftIndex == leftArray.length) {
                array[i] = rightArray[rightIndex++];
            } else if(rightIndex == rightArray.length) {
                array[i] = leftArray[leftIndex++];
            } else {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0) {
                    array[i] = leftArray[leftIndex++];
                } else {
                    array[i] = rightArray[rightIndex++];
                }
            }
        }
    }
}
