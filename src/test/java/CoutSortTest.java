import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoutSortTest {

    @Test
    public void testCountSort(){
        int [] sourceArray = new int[] {5,4,10,2,1,8,5,0};
        int [] expectArray = new int[] {0,1,2,4,5,5,8,10};
        CountingSort countingSort = new CountingSort(sourceArray);
        countingSort.countSort();
        assertThat(countingSort.getArray()).isEqualTo(expectArray);
    }

    @Test
    public void testRedixSort(){
        int [] sourceArray = new int[] {5,410,10,2,1,850,5,0};
        int [] expectArray = new int[] {0,1,2,5,5,10,410,850};
        CountingSort countingSort = new CountingSort(sourceArray);
        countingSort.redixSort();
        assertThat(countingSort.getArray()).isEqualTo(expectArray);
    }
}
