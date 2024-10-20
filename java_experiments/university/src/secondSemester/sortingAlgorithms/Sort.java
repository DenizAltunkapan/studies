package secondSemester.sortingAlgorithms;

public interface Sort {
    void sort(int[] array);

    default void swap(int a, int b, int[] array){
        int temp= array[a];
        array[a]= array[b];
        array[b]= temp;
    }

    default int findMin(int beginIndex, int endIndex, int[] array){
        int min = array[0];
        for(int i = 0; i< array.length; i++){
            if(array[i] < min){
                min= array[i];
            }
        }
        return min;
    }
}
