package org.zxz.hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author LEGION
 * 128 最长连续序列
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //{100, 4, 200, 1, 3, 2};
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int cnt = 1;
            while (set.contains(num + 1)) {
                num = num + 1;
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
