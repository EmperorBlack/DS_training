package MinPathSum;

import java.util.Arrays;

public class MinPathSumDriver {
    public static void main(String[] args) {

        int[][] grid = new int[][]{{5 ,9 ,6},{11, 5, 2}};
        System.out.println(Solution.minSumPath(grid));
    }
}

 class Solution {
    public static int minSumPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i],-1);
        }
        return findMinPathTab(grid,row,col,dp);

    }

    public static  int findMinPath(int[][] grid,int i, int j,int dp[][]){

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == 0 && j ==0){
            return grid[i][j];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i > 0){
            up = findMinPath(grid,i-1,j, dp);
        }
        if(j>0){
            left = findMinPath(grid, i, j-1,dp);
        }
        return dp[i][j] = Math.min(up,left)+grid[i][j];
    }

     public static  int findMinPathTab(int[][] grid,int row,int col,int dp[][]){


        dp[0][0] = grid[0][0];
         for (int i = 0; i < row; i++) {
             for (int j = 0; j < col; j++) {

                 if (i!= 0 || j!=0){


                     int up = Integer.MAX_VALUE;
                     int left = Integer.MAX_VALUE;
                     if(i > 0){
                         up = dp[i-1][j];
                     }
                     if(j > 0){
                         left = dp[i][j-1];
                     }
                     dp[i][j] = Math.min(up,left)+grid[i][j];
                 }
             }
         }
         return dp[row-1][col-1];
     }
}
