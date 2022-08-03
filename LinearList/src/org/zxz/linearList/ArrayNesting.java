package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 嵌套数组
 * https://leetcode.cn/problems/array-nesting/description/
 */
public class ArrayNesting {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str_nums = br.readLine().split(" ");
            int n = str_nums.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str_nums[i]);
            }
            System.out.println(maxNesting(nums));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int maxNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
