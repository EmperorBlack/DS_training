package ballonBrust;

import java.util.Arrays;

public class BallonBrustDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int maxCoins(int a[]) {
        // Write your code here..
        int arr[] = new int[a.length+2];
        arr[0] = 1;
        arr[a.length+1] = 1;
        for (int i = 1; i < arr.length-1; i++) {
            arr[i] = a[i-1];
        }
        int dp[][] = new int[a.length+1][a.length+1];
        for (int[] d:dp
             ) {
            Arrays.fill(d,-1);
        }

        return findMaxCoin(1,a.length,arr,dp);

    }

    public static int findMaxCoin(int i,int j,int arr[],int dp[][]){

        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxCoin = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {

            int coins = arr[i-1] * arr[j+1] * arr[k] + findMaxCoin(i,k-1,arr,dp) + findMaxCoin(k+1,j,arr,dp);
            maxCoin = Math.max(coins,maxCoin);
        }
        return dp[i][j] = maxCoin;

    }

}