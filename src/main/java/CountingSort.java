import java.util.Arrays;

public class CountingSort  {

    int[] array;

    public CountingSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int[] getArray() {
        return array;
    }

    public void countSort() {
        int max = Arrays.stream(array).max().getAsInt();
        int[] count = new int[max + 1];

        for(int i=0; i < array.length; i++) {
            count[array[i]]++;
        }

        for(int i=1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        int[] sortedArray = new int[array.length];
        for(int i=sortedArray.length-1; i >= 0; i--) {
            sortedArray[count[array[i]] - 1]=array[i];
            count[array[i]]--;
        }
        array = Arrays.copyOf(sortedArray,sortedArray.length);
        //return sortedArray;
    }

    public void redixSort() {
        int max = Arrays.stream(array).max().getAsInt();
        for(int exp=1; max/exp > 0; exp*=10) {
            int[] sortedArray = countSortForRedix(exp);
            array = Arrays.copyOf(sortedArray,sortedArray.length);
        }
    }



    public int[]  countSortForRedix(int exp) {
//        int max = Arrays.stream(array).max().getAsInt();
//        int min = Arrays.stream(array).min().getAsInt();
//        int [] countArray = new int[max-min+1];

        int [] countArray = new int[10];

//        for (int i=0; i < array.length; i++) {
//            countArray[array[i]-min]++;
//        }
        for (int i=0; i < array.length; i++) {
            countArray[array[i]/exp % 10]++;
        }
        for(int i= 1 ; i < countArray.length; i++) {
            countArray[i]+=countArray[i-1];
        }
//        for(int i= countArray.length - 2 ; i>=0; i--) {
//            countArray[i]+=countArray[i+1];
//        }
        int[] sortedArray = new int[array.length];
        for(int i=sortedArray.length-1; i >= 0; i--) {
            sortedArray[countArray[array[i]/exp % 10]-1] = array[i];
            countArray[array[i]/exp % 10]--;
        }
        return sortedArray;
    }
}
