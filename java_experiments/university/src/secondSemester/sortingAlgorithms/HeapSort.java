package secondSemester.sortingAlgorithms;

public class HeapSort implements Sort{
    @Override
    public void sort(int[] array) {
        for(int i=
            array.length/2 -1;i>=0;i--) {
            createHeap(i,array);
        }
    }
    private void createHeap(int i,int[] array){
            int min = i;
            if(2*i<array.length && array[2*i]< array[i]){
                min=2*i;
            }
            if(2*i+1<array.length && array[2*i+1]< array[i]){
                min=2*i+1;
            }

        if (min != i) {
            swap(i, min, array);

            // Rekursiver Aufruf, um den Rest des Baums zu heapifyen
            createHeap(min,array);
        }
    }
}
