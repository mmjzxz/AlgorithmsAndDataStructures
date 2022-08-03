package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 769 分隔数组
 * https://leetcode-cn.com/problems/max-chunks-to-make-sorted/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str_nums = br.readLine().split(" ");
            int n = str_nums.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str_nums[i]);
            }
            System.out.println(maxChunksToMakeSorted(nums));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int maxChunksToMakeSorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = 0;
        int right = nums[0];
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
            if (i == right) {
                ret++;
            }
        }
        return ret;
    }
}


