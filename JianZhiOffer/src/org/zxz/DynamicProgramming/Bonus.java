package org.zxz.DynamicProgramming;

/**
 * @author LEGION
 * https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab
 * https://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3/47.%20%E7%A4%BC%E7%89%A9%E7%9A%84%E6%9C%80%E5%A4%A7%E4%BB%B7%E5%80%BC.html#%E9%A2%98%E7%9B%AE%E6%8F%8F%E8%BF%B0
 */

public class Bonus {
    public static void main(String[] args) {
        int[][] keys = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(getBonus(keys));
    }

    public static int getBonus(int[][] keys) {
        if (keys == null || keys.length == 0 || keys[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[keys.length][keys[0].length];
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < keys[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = keys[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + keys[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + keys[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + keys[i][j];
                }
            }
        }
        return dp[keys.length - 1][keys[0].length - 1];
    }
}
