package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * For example, given nums = [0, 1, 0, 3, 12],
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            moveZeroes(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveZeroes(int[] arr) {
        int index = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }
}
