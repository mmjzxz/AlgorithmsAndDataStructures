package org.zxz.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LEGION
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 最长不含重复字符的子字符串
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] pre = new int[26];
        Arrays.fill(pre, -1);
        for (int i = 0; i < s.length(); i++) {

        }
    }
}
