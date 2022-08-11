package org.zxz.DynamicProgramming;

/**
 * @author LEGION
 * 连续子数组的最大和
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -8, -1, -5, -9};
        System.out.println(findGreatestSumOfSubArray(arr));
    }

    private static int findGreatestSumOfSubArray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int findGreatestSumOfSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
