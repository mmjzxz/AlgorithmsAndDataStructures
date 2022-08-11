package org.zxz.sort;

/**
 * @author LEGION
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 改进冒泡排序
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
