package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 找出数组中重复的数，数组值在 [1, n] 之间
 * 287 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str_nums = br.readLine().split(" ");
            int n = str_nums.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str_nums[i]);
            }
            System.out.println(findDuplicate(nums));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
