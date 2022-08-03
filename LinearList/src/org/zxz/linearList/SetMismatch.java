package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author LEGION
 * 645 错误的集合
 * https://leetcode-cn.com/problems/set-mismatch/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class SetMismatch {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str_nums = br.readLine().split(" ");
            int n = str_nums.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str_nums[i]);
            }
            int[] res = findErrorNums(nums);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res[1] = i + 1;
                res[0] = nums[i];
                break;
            }
        }
        return res;
    }
}
