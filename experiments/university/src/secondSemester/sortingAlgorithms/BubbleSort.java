package secondSemester.sortingAlgorithms;

public class BubbleSort implements Sort{
    @Override
    public void sort(int[] array) {
        for(int i= 0; i< array.length; i++){
            for(int k= 0; k< array.length-i-1; k++){
                if(array[k] > array[k + 1]){
                    swap(k,k+1,array);
                }
            }
        }
    }


}
