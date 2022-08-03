package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 改变矩阵维度
 * https://leetcode.com/problems/reshape-the-matrix/description/
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * <p>
 * Output:
 * [[1,2,3,4]]
 * <p>
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 * fill it row by row by using the previous list.
 */
public class ReshapeMatrix {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strs = new String[3];
            for (int i = 0; i < strs.length; i++) {
                strs[i] = br.readLine();
            }
            String[] s = strs[0].split(" ");
            int[][] arr = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
            s = strs[1].split(" ");
            int num = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = Integer.parseInt(s[num++]);
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            s = strs[2].split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            int[][] res = shapeMatrix(arr, r, c);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[][] shapeMatrix(int[][] arr, int r, int c) {
        int row = arr.length;
        int col = arr[0].length;
        if (arr == null || row * col != r * c) {
            return arr;
        }
        int index = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = arr[index / row][index++ % col];
            }
        }
        return result;
    }
}
