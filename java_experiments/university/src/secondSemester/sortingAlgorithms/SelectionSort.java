package secondSemester.sortingAlgorithms;

public class SelectionSort implements Sort{


    @Override
    public void sort(int[] array) {
        for(int i=0; i < array.length; i++){
            for(int j =i;j< array.length; j++ ){
                if(array[i] > array[j]){
                    swap(i,j,array);
                }
            }
        }
    }


}
