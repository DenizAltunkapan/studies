package secondSemester.searchAlgorithms;

/*@
 * @class_invariant list is sorted
 */
public class BinarySearch implements Search{

    /*@
     @  requires given collection is sorted
     @  ensures the index of the to be searched target will be returned
     */
    @Override
    public int search(int[] array, int target) {
        int left=0;
        int right=array.length-1;
        while(left<right){
            int mid= (left+right)/2;
            if(array[mid]==target){
                return mid;
            }
            if(target>array[mid]){
                left=mid+1;
            }
            if(target<array[mid]){
                right= mid-1;
            }
        }
        return -1;
    }

}
