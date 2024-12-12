package thirdSemester.test;

import org.junit.jupiter.api.Test;
import thirdSemester.quickSelect.QuickSelect;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.common.NormalizedString.toArray;

public class QuickSelectTest {

    @Test
    public void test1() {
        int[] arr = {2, 3, 5, 7, 8, 1, 3, 12, 6, 53, 42, 34, 29};
        Integer[] exp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(exp, Comparator.reverseOrder());

        QuickSelect qs = new QuickSelect(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(exp[i], qs.findKthLargest(i + 1));
        }
    }

    @Test
    public void test2() {
        int[] arr = {4,653,5,2,5,34,5,3,5,24,4,4,2,46,7,4,23,325,98,2,33,3,643,674,233,455,77,33,32,95};
        Integer[] exp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(exp, Comparator.reverseOrder());

        QuickSelect qs = new QuickSelect(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(exp[i], qs.findKthLargest(i + 1));
        }
    }

    @Test
    public void test3() {
        int[] arr = {-33,53,23,-36,74,-97,29,1,100,56,30,40};
        Integer[] exp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(exp, Comparator.reverseOrder());

        QuickSelect qs = new QuickSelect(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(exp[i], qs.findKthLargest(i + 1));
        }
    }

}
