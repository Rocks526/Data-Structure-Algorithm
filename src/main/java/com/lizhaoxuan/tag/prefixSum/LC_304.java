package com.lizhaoxuan.tag.prefixSum;

/**
 * 【304】二维区域和检索 - 矩阵不可变
 * @author lizhaoxuan
 */
public class LC_304 {

    static class NumMatrix {
        // 前缀和数组，prefix[i][j]存储matrix[0][0]到matrix[i-1][j-1]的矩阵和
        private int[][] prefix;
        public NumMatrix(int[][] matrix) {
            int col = matrix[0].length;
            int row = matrix.length;
            if (row == 0 || col == 0){
                return;
            }
            // 构造前缀和数组
            prefix = new int[row+1][col+1];
            prefix[0][0] = prefix[0][1] = prefix[1][0]= 0;
            for (int i=1;i<=row;i++){
                for (int j=1;j<=col;j++){
                    prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + matrix[i-1][j-1] - prefix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefix[row2+1][col2+1] - prefix[row1][col2+1] - prefix[row2+1][col1] + prefix[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        printMatrix(matrix);
        printMatrix(numMatrix.prefix);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }

    private static void printMatrix(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

}
