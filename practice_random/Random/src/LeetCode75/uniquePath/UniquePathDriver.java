package LeetCode75.uniquePath;

import java.util.Arrays;

public class UniquePathDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] arr: dp
             ) {
            Arrays.fill(arr,-1);
        }
        return findUniquePath(m-1,n-1,dp);

    }

    public int findUniquePath(int m, int n, int dp[][]){
        if(m==0 && n==0){
            return 1;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int top =0;
        int left =0;
        if(m-1 >=0){
            top = findUniquePath(m-1,n,dp);
        }
        if(n-1 >=0){
            left = findUniquePath(m,n-1,dp);
        }
        return dp[m][n] = top+left;


    }
}
