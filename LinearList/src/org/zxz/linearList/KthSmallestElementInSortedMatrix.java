package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LEGION
 * 有序矩阵的 Kth Element
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] strs = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(strs[j]);
                }
            }
            int k = Integer.parseInt(br.readLine());
            System.out.println(kthSmallest(arr, k));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int kthSmallest(int[][] arr, int k) {
        int n = arr.length;
        int m = arr[0].length;
        int index = 0;
        int[] res = new int[n * m];
        for (int j = 0; j < m * n; j++) {
            res[j] = arr[index / n][index++ % m];
        }
        Arrays.sort(res);
        return res[k - 1];
    }
}
