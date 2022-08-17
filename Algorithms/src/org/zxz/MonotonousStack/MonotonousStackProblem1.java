package org.zxz.MonotonousStack;

import java.util.Stack;

/**
 * @author LEGION
 * 数组中所有数都是正数，数组中累积和与最小值的乘积， 假设叫做指标A。
 * 给定一个数组， 请返回子数组中， 指标A最大的值。
 */
public class MonotonousStackProblem1 {
    public static void main(String[] args) {
        int[] arr = {13, 21, 78, 80, 9};
        System.out.println(getMaxAMonotonousStack(arr));
    }

    /**
     * 暴力解
     *
     * @param arr
     * @return
     */
    private static int getMaxA(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int min = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    min = Math.min(min, arr[k]);
                }
                max = Math.max(max, sum * min);
            }
        }
        return max;
    }

    /**
     * 单调栈
     *
     * @param arr
     * @return
     */
    private static int getMaxAMonotonousStack(int[] arr) {
        int max = Integer.MIN_VALUE;
        int length = arr.length;
        int[] sum = new int[length];
        sum[0] = arr[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int pop = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sum[i - 1] : (sum[i - 1] - sum[stack.peek()])) * arr[pop]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sum[length - 1] : (sum[length - 1] - sum[stack.peek()])) * arr[pop]);
        }
        return max;
    }
}
