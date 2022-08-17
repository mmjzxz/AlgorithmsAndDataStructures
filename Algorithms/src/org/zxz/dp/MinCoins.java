package org.zxz.dp;

/**
 * @author LEGION
 */
public class MinCoins {
    public static void main(String[] args) {
        int target = 10;
        int[] coins = {10};
        System.out.println(minCoins(coins, target, 0));
        int[][] dp = new int[coins.length + 1][target + 1];
        initDP(dp);
        System.out.println(minCoins2(coins, target, 0, dp));
    }

    /**
     * @param arr:    the array of coins, fixed parameters
     * @param target: the target amount of money
     * @param index:  the index of the coin
     * @return
     */
    public static int minCoins(int[] arr, int target, int index) {
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int possible1 = minCoins(arr, target, index + 1);
        int possible2 = minCoins(arr, target - arr[index], index + 1);
        if (possible1 == -1 && possible2 == -1) {
            return -1;
        } else {
            if (possible1 == -1) {
                return possible2 + 1;
            } else if (possible2 == -1) {
                return possible1;
            } else {
                return Math.min(possible1, possible2 + 1);
            }
        }
    }

    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -2;
            }
        }
    }

    /**
     * @param arr:    the array of coins, fixed parameters
     * @param target: the target amount of money
     * @param index:  the index of the coin
     * @param dp:     the array of dp
     * @return
     */
    public static int minCoins2(int[] arr, int target, int index, int[][] dp) {
        if (target < 0) {
            return -1;
        }
        if (dp[index][target] != -2) {
            return dp[index][target];
        }
        if (target == 0) {
            dp[index][target] = 0;
        } else if (index == arr.length) {
            dp[index][target] = -1;
        } else {
            int possible1 = minCoins2(arr, target, index + 1, dp);
            int possible2 = minCoins2(arr, target - arr[index], index + 1, dp);
            if (possible1 == -1 && possible2 == -1) {
                dp[index][target] = -1;
            } else {
                if (possible1 == -1) {
                    dp[index][target] = possible2 + 1;
                } else if (possible2 == -1) {
                    dp[index][target] = possible1;
                } else {
                    dp[index][target] = Math.min(possible1, possible2 + 1);
                }
            }
        }
        return dp[index][target];
    }
}
