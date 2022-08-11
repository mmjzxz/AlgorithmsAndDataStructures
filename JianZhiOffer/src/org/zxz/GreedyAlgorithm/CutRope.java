package org.zxz.GreedyAlgorithm;

/**
 * @author LEGION
 * https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&tab=answerKey&from=cyc_github
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(cutRope1(4));
        System.out.println(cutRope1(5));
        System.out.println(cutRope1(10));
        System.out.println(cutRope1(11));
        System.out.println(cutRope1(15));
    }

    public static int cutRope1(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int times3 = target / 3;
        if (target % 3 == 1) {
            times3--;
        }
        //Math.pow(2, (target - 3 * times3) / 2));
        return (int) (Math.pow(3, times3) * ((target - 3 * times3) == 0 ? 1 : target - 3 * times3));
    }

    public static int cutRope2(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], dp[i - j]) * (i - j));
            }
        }
        return dp[target];
    }
}
