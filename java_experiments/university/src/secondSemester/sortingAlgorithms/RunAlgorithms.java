package secondSemester.sortingAlgorithms;

import java.util.*;

public class RunAlgorithms {
    public static void main(String[] args) {
        int[] myArray= {7,6,13,26,23,3,1,5,12,24,10,4,9};
        SortingAlgorithm algorithm = new SortingAlgorithm();
        algorithm.setAlgortihm(new SelectionSort());
        //algorithm.getAlgortihm().sort(myArray);
        System.out.println(Arrays.toString(myArray));
        InsertionSort ins = new InsertionSort();
        ins.reverseSort(myArray);
        System.out.println(Arrays.toString(myArray));

    }

}
