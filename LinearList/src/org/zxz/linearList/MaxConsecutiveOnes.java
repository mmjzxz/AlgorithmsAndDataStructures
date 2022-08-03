package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 找出数组中最长的连续 1
 * https://leetcode-cn.com/problems/max-consecutive-ones/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] s = br.readLine().split(" ");
            int n = s.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            System.out.println(maxConsecutiveOnes(arr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int maxConsecutiveOnes(int[] arr) {
        int max = 0;
        int cur = 0;
        for (int num : arr) {
            if (num == 1) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        return Math.max(max, cur);
    }
}
