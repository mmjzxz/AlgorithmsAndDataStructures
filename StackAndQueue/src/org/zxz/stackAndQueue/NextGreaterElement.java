package org.zxz.stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author LEGION
 * 503 循环数组中比当前元素大的下一个元素
 * https://leetcode.cn/problems/next-greater-element-ii/description/
 */
public class NextGreaterElement {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }
}
