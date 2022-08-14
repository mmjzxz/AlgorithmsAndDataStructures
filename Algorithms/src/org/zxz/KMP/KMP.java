package org.zxz.KMP;

/**
 * @author LEGION
 */
public class KMP {
    public static void main(String[] args) {

    }

    public static int getIndexOf(String source, String target) {
        if (source == null || target == null || target.length() < 1 || source.length() < target.length()) {
            return -1;
        }
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNextArray(targetChars);
        while (i < sourceChars.length && j < targetChars.length) {
            if (sourceChars[i] == targetChars[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == targetChars.length ? i - j : -1;
    }

    public static int[] getNextArray(char[] targetChars) {
        if (targetChars.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[targetChars.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < next.length) {
            if (targetChars[index - 1] == targetChars[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }
}
