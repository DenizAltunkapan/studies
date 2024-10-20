package secondSemester.sortingAlgorithms;

import java.util.Arrays;

public class MergeSort implements Sort{
    @Override
    public void sort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            // Teile das Array in zwei Hälften
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);
            // Sortiere jede Hälfte rekursiv
            sort(left);
            sort(right);

            // Führe die beiden sortierten Hälften zusammen
            merge(array, left, right);
        }
    }

    private void merge(int[] array, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = 0;

        // Vergleiche die Elemente beider Teilarrays und füge das kleinere Element in das Array ein
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[arrayIndex] = left[leftIndex];
                leftIndex++;
            } else {
                array[arrayIndex] = right[rightIndex];
                rightIndex++;
            }
            arrayIndex++;
        }

        // Kopiere die verbleibenden Elemente aus dem linken Array, falls vorhanden
        while (leftIndex < left.length) {
            array[arrayIndex] = left[leftIndex];
            leftIndex++;
            arrayIndex++;
        }

        // Kopiere die verbleibenden Elemente aus dem rechten Array, falls vorhanden
        while (rightIndex < right.length) {
            array[arrayIndex] = right[rightIndex];
            rightIndex++;
            arrayIndex++;
        }
    }


}
