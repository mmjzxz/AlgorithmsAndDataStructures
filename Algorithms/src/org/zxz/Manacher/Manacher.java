package org.zxz.Manacher;

/**
 * @author LEGION
 */
public class Manacher {
    public static void main(String[] args) {
        String s1 = "abadaba";
        System.out.println(maxLcpsLength(s1));
        String s2 = "abacabc";
        System.out.println(maxLcpsLength(s2));
    }

    public static char[] manacherString(String s) {
        char[] charArr = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        // 1221 -> #1#2#2#1#
        char[] str = manacherString(s);
        // 回文半径数组
        int[] pArr = new int[str.length];
        // 回文中心
        int C = -1;
        // 回文右边界的再往右一个位置，最右的有效区为R-1位置
        int R = -1;
        // 扩出的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i - pArr[i] >= 0 && i + pArr[i] < str.length) {
                if (str[i - pArr[i]] == str[i + pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                C = i;
                R = i + pArr[i];
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
}
