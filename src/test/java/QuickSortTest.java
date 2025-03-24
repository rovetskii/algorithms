import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {

    @Test
    public void testQuickSort(){
        Integer [] sourceArray = new Integer[] {-5,4,10,2,1,8,-5,0};
        Integer [] expectArray = new Integer[] {-5, -5, 0, 1,2,4,8, 10};
        QuickSort<Integer> quickSortAlg = new QuickSort<>(sourceArray);
        quickSortAlg.quickSortArray(0, sourceArray.length - 1);
        assertThat(quickSortAlg.getArray()).isEqualTo(expectArray);
    }

    @Test
    public void testQuickSortForStat(){
        Integer [] sourceArray = new Integer[] {-5,4,10,2,1,8,-5,0};
//        Integer [] expectArray = new Integer[] {-5, -5, 0, 1,2,4,8, 10};
        QuickSort<Integer> quickSortAlg = new QuickSort<>(sourceArray);
        quickSortAlg.quickSortForStatistic(0, sourceArray.length - 1, 5);
        assertThat(quickSortAlg.getArray()[5]).isEqualTo(4);
    }

    @Test
    public void testMergeSort() {
        Integer[] sourceArray = new Integer[]{-5, 4, 10, 2, 1, 8, -5, 0};
        Integer[] expectArray = new Integer[]{-5, -5, 0, 1, 2, 4, 8, 10};
        MergeSort<Integer> mergeSortAlg = new MergeSort<>(sourceArray);
        mergeSortAlg.mergeSort();
        assertThat(mergeSortAlg.getArray()).isEqualTo(expectArray);
    }

}
