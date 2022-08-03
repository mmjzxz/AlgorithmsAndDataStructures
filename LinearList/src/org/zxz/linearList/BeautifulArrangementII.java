package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 667 数组相邻差值的个数
 * https://leetcode.cn/problems/beautiful-arrangement-ii/description/
 */

public class BeautifulArrangementII {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str_nums = br.readLine().split(" ");
            int n = Integer.parseInt(str_nums[0]);
            int k = Integer.parseInt(str_nums[1]);
            int[] ints = countArrangement(n, k);
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] countArrangement(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
