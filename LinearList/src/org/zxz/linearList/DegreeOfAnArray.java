package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LEGION
 * 数组的度
 * https://leetcode-cn.com/problems/degree-of-an-array/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str_nums = br.readLine().split(" ");
            int n = str_nums.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str_nums[i]);
            }
            System.out.println(findDegree(nums));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findDegree(int[] nums) {
        Map<Integer, List<Integer>> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            count.get(nums[i]).add(i);
        }
        int max = 0;
        int res = Integer.MAX_VALUE;
        for (Map.Entry entry : count.entrySet()) {
            List<Integer> value = (List) entry.getValue();
            if (value.size() > max) {
                max = value.size();
                res = value.get(value.size() - 1) - value.get(0);
            }

            if (value.size() == max && value.get(value.size() - 1) - value.get(0) < res) {
                res = value.get(value.size() - 1) - value.get(0);
            }
        }
        return res + 1;
//        int num = 0;
//        int max = 0;
//        for (Map.Entry entry : count.entrySet()) {
//            if ((int) entry.getValue() > max) {
//                max = (int) entry.getValue();
//                num = (int) entry.getKey();
//            }
//        }
//        int start = 0;
//        int end = nums.length - 1;
//        while (start + max < end && (nums[start] != num || nums[end] != num)) {
//            start = nums[start] != num ? start + 1 : start;
//            end = nums[end] != num ? end - 1 : end;
//        }
//        return end - start + 1;
    }
}
