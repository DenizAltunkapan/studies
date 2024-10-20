package secondSemester.sortingAlgorithms;

public class InsertionSort implements Sort{
    @Override
    public void sort(int[] array) {
        for(int i=1; i< array.length; i++){
            int currentValue= array[i];
            int j= i-1;
            while (j>=0 &&  array[j] > currentValue){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = currentValue;
        }
    }

    public void reverseSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int p=i-1;
            while(p>=0 && current>array[p]){
                array[p+1]=array[p];
                p--;
            }
            array[p+1]= current;
        }
    }
}
