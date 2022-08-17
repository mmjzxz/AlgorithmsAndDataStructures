package org.zxz.dp;

/**
 * @author LEGION
 * https://leetcode.cn/problems/predict-the-winner/
 */
public class PredictTheWinner {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2};
        System.out.println(offensivePosition(arr, 0, arr.length - 1));
        System.out.println(defensivePosition(arr, 0, arr.length - 1));
        System.out.println(dpWinner(arr));
    }

    /**
     * 先手
     *
     * @param arr:   the array of scores, fixed parameters
     * @param first: the first index of the array that may be chosen
     * @param last:  the last index of the array that may be chosen
     * @return the maximum score that can be achieved by the first player
     */
    public static int offensivePosition(int[] arr, int first, int last) {
        if (first == last) {
            return arr[first];
        }
        return Math.max(arr[first] + defensivePosition(arr, first + 1, last),
                arr[last] + defensivePosition(arr, first, last - 1));
    }

    /**
     * 后手
     *
     * @param arr:   the array of scores, fixed parameters
     * @param first: the first index of the array that may be chosen
     * @param last:  the last index of the array that may be chosen
     * @return the maximum score that can be achieved by the second player
     */
    public static int defensivePosition(int[] arr, int first, int last) {
        if (first == last) {
            return 0;
        }
        return Math.min(offensivePosition(arr, first + 1, last),
                offensivePosition(arr, first, last - 1));
    }

    /**
     * @param arr
     * @return
     */
    public static int dpWinner(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] offensive = new int[arr.length][arr.length];
        int[][] defensive = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            offensive[i][i] = arr[i];
        }
        int row = 0;
        int col = 1;
        while (col < arr.length) {
            int i = row;
            int j = col;
            while (i < arr.length && j < arr.length) {
                offensive[i][j] = Math.max(arr[i] + defensive[i + 1][j], arr[j] + defensive[i][j - 1]);
                defensive[i][j] = Math.min(offensive[i][j - 1], offensive[i + 1][j]);
                i++;
                j++;
            }
            col++;
        }
        return Math.max(offensive[0][arr.length - 1], defensive[0][arr.length - 1]);
    }
}
