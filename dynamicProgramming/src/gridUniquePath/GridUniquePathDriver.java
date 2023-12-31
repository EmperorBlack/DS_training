package gridUniquePath;

import java.util.Arrays;

public class GridUniquePathDriver {
    public static void main(String[] args) {

        System.out.println(Solution.uniquePaths(3,3));
    }
}

class Solution {
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],-1);
        }
        return findPath(m-1,n-1,dp);
    }

    public static int findPath(int i ,int j,int[][] dp){
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        if(i==0 && j==0){
            dp[i][j] =1;
            return 1;
        }
        int left = 0;
        int right = 0;
        if(i>0){
            left = findPath(i-1,j,dp);
        }
        if(j>0){
            right = findPath(i,j-1, dp);
        }
        return dp[i][j] = left+right;

    }
}
