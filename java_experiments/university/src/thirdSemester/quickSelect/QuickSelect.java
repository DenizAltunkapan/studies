package thirdSemester.quickSelect;

import java.util.Arrays;

public class QuickSelect {

    private int[] nums;

    /**
     * Constructor to initialize the array.
     *
     * @param nums The array to find the k-th largest element in.
     */
    public QuickSelect(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        this.nums = nums;
    }

    /**
     * Finds the k-th largest element in a given array.
     *
     * @param k The position of the k-th largest element.
     * @return The k-th largest element.
     */
    public int findKthLargest(int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        int length = nums.length;
        return select(0, length - 1, length - k);
    }

    /**
     * Recursive selection process to find the k-th smallest element.
     *
     * @param left      The left boundary of the range.
     * @param right     The right boundary of the range.
     * @param kSmallest The index of the k-th smallest element.
     * @return The k-th smallest element.
     */
    private int select(int left, int right, int kSmallest) {
        if (left == right) return nums[left];

        int pivotIndex = medianOfMedians(left, right);
        pivotIndex = partition(left, right, pivotIndex);

        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return select(left, pivotIndex - 1, kSmallest);
        } else {
            return select(pivotIndex + 1, right, kSmallest);
        }
    }

    /**
     * Computes the median of medians as the pivot element.
     *
     * @param left  The left boundary of the range.
     * @param right The right boundary of the range.
     * @return The pivot index.
     */
    private int medianOfMedians(int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            Arrays.sort(nums, left, right + 1); // Sort the subarray
            return left + (right - left) / 2;  // Return the median index
        }

        int[] medians = new int[(n + 4) / 5];
        for (int i = 0; i < medians.length; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(nums, subLeft, subRight + 1); // Sort each group of at most 5 elements
            medians[i] = nums[subLeft + (subRight - subLeft) / 2]; // Find the median of the group
        }

        // Use QuickSelect recursively to find the median of the medians
        QuickSelect medianSelector = new QuickSelect(medians);
        int medianValue = medianSelector.findKthLargest((medians.length + 1) / 2);

        // Find the index of the median value in the original array
        for (int i = left; i <= right; i++) {
            if (nums[i] == medianValue) {
                return i;
            }
        }

        throw new IllegalStateException("Median not found in array");
    }

    /**
     * Partitions the array around a pivot.
     *
     * @param left       The left boundary of the range.
     * @param right      The right boundary of the range.
     * @param pivotIndex The index of the pivot.
     * @return The new index of the pivot.
     */
    private int partition(int left, int right, int pivotIndex) {
        if (pivotIndex < left || pivotIndex > right) {
            throw new IllegalArgumentException("Invalid pivot index");
        }

        int pivotValue = nums[pivotIndex];
        swap(pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(i, storeIndex);
                storeIndex++;
            }
        }

        swap(storeIndex, right);
        return storeIndex;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
