package org.zxz.GreedyAlgorithm;

import java.util.Stack;

/**
 * @author LEGION
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
