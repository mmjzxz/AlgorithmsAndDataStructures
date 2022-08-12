package org.zxz.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LEGION
 * 1 两数之和
 * https://leetcode.cn/problems/two-sum/
 */
public class TwoSum1 {
    public static void main(String[] args) {
        TwoSum1 twoSum1 = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // twoSum1.twoSum(nums, target);
        int[] result = twoSum1.twoSumHashMap(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    /**
     * 哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
        // throw new IllegalArgumentException("No two sum solution");
    }
}
