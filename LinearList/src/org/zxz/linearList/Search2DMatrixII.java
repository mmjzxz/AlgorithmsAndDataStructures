package org.zxz.linearList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LEGION
 * 有序矩阵查找
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class Search2DMatrixII {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());
            String rowAndCol = br.readLine();
            int n = Integer.parseInt(rowAndCol.split(" ")[0]);
            int m = Integer.parseInt(rowAndCol.split(" ")[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(s[j]);
                }
            }
            System.out.println(searchMatrix(matrix, target));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
