package secondSemester.sortingAlgorithms;

public class QuickSort implements Sort{

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    private void quickSort(int[] array, int start, int end){
        if(end>start){
            int pn = zerlege(array,start,end);
            quickSort(array,start,pn-1);
            quickSort(array,pn+1,end);
        }
    }
    private int zerlege(int[] array, int start, int end){
        swap((start+end)/2,end,array);
        int pivot= array[end];
        int pn=start;
        for(int i=start;i<end;i++){
            if(array[i]<pivot){
                swap(i,pn,array);
                pn++;
            }
        }
        swap(pn,end,array);
        return pn;
    }

}
