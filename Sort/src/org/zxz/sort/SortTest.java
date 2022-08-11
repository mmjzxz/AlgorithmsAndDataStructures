package org.zxz.sort;

/**
 * @author LEGION
 */
public class SortTest {
    public static void main(String[] args) {
        int[] keys = {8, 2, 3, 1, 5, 7, 6, 4};
        BubbleSort.bubbleSort(keys);
        print(keys);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
