package dynamicProgramming.longestIncreasingSubsequences;

import java.util.Arrays;

public class LongestIncreasingSubsequncesDriver {


}

 class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {

        int[][] dp = new int[arr.length][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return findLongestIncSub(arr,0,-1,dp);

    }
     public static int findLongestIncSub(int arr[],int ind, int prv,int[][] dp){

         if(ind == arr.length){
             return 0;
         }

         if(dp[ind][prv+1] != -1){
             return dp[ind][prv+1];
         }

         int take = 0;
         int notTake = findLongestIncSub(arr, ind+1,prv,dp);
         if(prv ==-1 || arr[prv] < arr[ind]){
             take = 1+findLongestIncSub(arr,ind+1,ind, dp);
         }
         return dp[ind][prv+1] = Math.max(take,notTake);




     }

    public static int findLongest(int arr[], int ind, int prv, int dp[][]){

        if(ind == arr.length){
            return 0;
        }

        if(dp[ind][prv+1] !=-1){
            return dp[ind][prv+1];
        }

        int take = 0;
        if(prv == -1 || arr[prv] < arr[ind]){
            take = 1+findLongest(arr,ind+1,ind,dp);
        }
        int notTake = findLongest(arr,ind+1, prv,dp);

        return dp[ind][prv+1] = Math.max(take,notTake);


    }
}
