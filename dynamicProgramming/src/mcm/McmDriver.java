package mcm;

import java.util.Arrays;

public class McmDriver {
    public static void main(String[] args) {

        System.out.println(Solution.matrixMultiplication(new int[]{10 ,15 ,20 ,25},4));
    }
}

class Solution {
    public static int matrixMultiplication(int[] arr , int N) {

        int dp[][] = new int[N][N];
        for (int ar[]: dp
             ) {
            Arrays.fill(ar,-1);
        }

       return getMCM(arr,1,N-1,dp);
    }

    public static int getMCM(int[] arr, int i, int j,int[][] dp){

        if(i==j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minSteps = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {

            int steps = (arr[i-1] * arr[k] * arr[j]) + getMCM(arr,i,k,dp)+ getMCM(arr, k+1, j,dp);
            minSteps = Math.min(minSteps,steps);

        }
        return dp[i][j] = minSteps;
    }
    public static int matrixMultiplicationTab(int[] arr , int N) {

        int dp[][] = new int[N][N];

        for(int i = N-1; i>=1;i--){
            for (int j = i+1; j <= N-1; j++) {

                int minSteps = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {

                    int steps = (arr[i-1] * arr[k] * arr[j]) + dp[i][k]+dp[k+1][j];
                    minSteps = Math.min(minSteps,steps);
                }
                dp[i][j] = minSteps;
            }
        }
        return dp[1][N-1];

    }
}
