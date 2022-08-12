package org.zxz.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LEGION
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class ClimbingStairs70 {
    private final static int N = 2;

    public static void main(String[] args) {
        ClimbingStairs70 climbingStairs70 = new ClimbingStairs70();
        System.out.println(climbingStairs70.climbStairs(3));
        System.out.println(climbingStairs70.climbStairs(4));
        System.out.println(climbingStairs70.climbStairs(5));
        System.out.println(climbingStairs70.climbStairs(6));
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= N) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int climbStairsNotRecursion(int n) {
        if (n <= N) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 爬楼梯优化
     *
     * @param n
     * @return
     */
    public int climbStairsOptimize(int n) {
        if (n <= N) {
            return n;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * HashMap
     *
     * @param n
     * @return
     */
    public int climbStairsHashMap(int n) {
        if (n <= N) {
            return n;
        }
        Map<Integer, Integer> map = new HashMap<>();
        if (null != map.get(n)) {
            return map.get(n);
        } else {
            int result = climbStairsHashMap(n - 1) + climbStairsHashMap(n - 2);
            map.put(n, result);
            return result;
        }
    }
}
