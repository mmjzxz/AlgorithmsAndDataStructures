package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 对角元素相等的矩阵
 * https://leetcode.cn/problems/toeplitz-matrix/description/
 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str_nums = br.readLine().split(" ");
            int n = Integer.parseInt(str_nums[0]);
            int m = Integer.parseInt(str_nums[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] str_row = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(str_row[j]);
                }
            }
            System.out.println(isToeplitzMatrix(matrix));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (!checkToeplitz(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (!checkToeplitz(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkToeplitz(int[][] matrix, int matrix1, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if (matrix1 != matrix[row][col]) {
            return false;
        }
        return checkToeplitz(matrix, matrix1, row + 1, col + 1);
    }
}
