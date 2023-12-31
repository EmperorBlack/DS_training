package SubSetSumEqualK;

import java.util.Arrays;

public class SubSetSum {
    public static void main(String[] args) {

        System.out.println(Solution.subsetSumToK(4,5,new int[]{1,2,3,4}));
    }
}

class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.

        int dp[][] = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        return findSubsets(k,n-1,arr,dp);
    }

//    public static boolean findSubsets2(int sum, int index,int arr[],int k){
//        if(sum == k){
//            return true;
//        }
//
//        if(sum > k  || index <0){
//            return false;
//        }
//
//        if(findSubsets2(sum + arr[index],index--,arr,k) || findSubsets2(sum ,index--,arr,k)){
//            return true;
//        }
//        return false;
//    }

    public static boolean findSubsets(int target, int index,int arr[],int[][] dp){
        if(target == 0){
            return true;
        }

        if(index ==0){
            return target == arr[0];
        }
        if(dp[index][target] != -1){
            return dp[index][target] == 1 ? true : false;
        }
        boolean pick = false;
        if(target >= arr[index]){
            pick = findSubsets(target - arr[index],index-1,arr,dp);
        }
        boolean nonPick = findSubsets(target,index-1,arr,dp);
        dp[index][target] = pick || nonPick ? 1 : 0;
        return pick || nonPick;
    }

    public static boolean findSubsetsTab(int k,int arr[],int n){

       boolean  dp[][] = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if(k >= arr[0]){
            dp[0][arr[0]] =true;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if(target >= arr[index]){
                    pick = dp[index-1][target-arr[index]];
                }
                boolean nonPick = dp[index-1][target];
                dp[index][target] = pick || nonPick;
            }
        }
        return dp[n-1][k];

    }
}
