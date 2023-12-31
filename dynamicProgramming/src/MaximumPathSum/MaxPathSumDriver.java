package MaximumPathSum;

import java.util.Arrays;

public class MaxPathSumDriver {
    public static void main(String[] args) {
        System.out.println(Solution.getMaxPathSum(new int[][]{{10 ,2 ,3},
                {3, 7, 2},
                {8 ,1 ,5}}));
    }
}

class Solution {
    public static int getMaxPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i],-1);
        }
        for (int i = 0; i < col; i++) {

            int subMax = getMax(matrix,row-1,i,dp);
            if(subMax > max){
                max = subMax;
            }
        }
        return max;

    }

    public static int getMax(int[][] matrix,int i,int j,int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i==0){
            return matrix[i][j];
        }
        int left = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(j>0){
            left = getMax(matrix,i-1,j-1,dp);
        }
        if(j<matrix[0].length-1){
            right = getMax(matrix,i-1,j+1,dp);
        }
        up = getMax(matrix,i-1,j,dp);
        return dp[i][j]=Math.max(Math.max(left,right),up)+matrix[i][j];
    }

    public static int getMaxPathSumTab(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if(i==0){
                    dp[i][j] = matrix[i][j];
                }else {

                    int left = Integer.MIN_VALUE;
                    int up = Integer.MIN_VALUE;
                    int right = Integer.MIN_VALUE;
                    if(j>0){
                        left = dp[i-1][j-1];
                    }
                    if(j<col-1){
                        right = dp[i-1][j+1];
                    }
                    up = dp[i-1][j];
                    dp[i][j]=Math.max(Math.max(left,right),up)+matrix[i][j];
                }
            }

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {

            int subMax = dp[row-1][i];
            if(subMax > max){
                max = subMax;
            }
        }
        return max;
    }
}

