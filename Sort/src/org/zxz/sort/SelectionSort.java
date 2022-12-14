package org.zxz.sort;

/**
 * @author LEGION
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
