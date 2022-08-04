package org.zxz.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LEGION
 * 217 判断数组是否有重复元素
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
