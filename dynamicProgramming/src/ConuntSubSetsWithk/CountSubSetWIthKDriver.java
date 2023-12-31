package ConuntSubSetsWithk;

import java.util.Arrays;

public class CountSubSetWIthKDriver {
    public static void main(String[] args) {

        System.out.println(Solution.findWays(new int[]{1,4,4,5},5));
    }
}

class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int dp[][] = new int[num.length][tar+1];
        for (int i = 0; i < num.length; i++) {
            Arrays.fill(dp[i],-1);
        }
//        return  findSubsets(tar, num.length-1,num,dp) ;
        return findSubsetsTab(tar,num);
    }


    public static int findSubsets(int target, int index,int arr[],int[][] dp){


        if(index == 0 ){
            if(target ==0 && arr[0] ==0){
                return 2;
            }
            if(target ==0 || arr[0] == target){
                return 1;
            }
            return 0;
        }
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        int pick = 0;
        if(target >= arr[index]){
            pick = findSubsets(target - arr[index],index-1,arr,dp);
        }
        int nonPick = findSubsets(target,index-1,arr,dp);

        return dp[index][target] = (pick+nonPick) %1000000007 ;
    }

    public static int findSubsetsTab(int tar,int arr[]){

        int[][] dp = new int[arr.length][tar+1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        if(arr[0] <= tar){
            dp[0][arr[0]] = 1;
        }


        if(arr[0] == 0){
            dp[0][0] = 2;
        }


        for (int ind = 1; ind < arr.length; ind++) {

            for (int target = 1; target <= tar; target++) {

                int pick = 0;
                if(target >= arr[ind]){
                    pick = dp[ind-1][target-arr[ind]];
                }
                int nonPick = dp[ind-1][target];
                dp[ind][target] = (pick+nonPick) %1000000007;
            }

        }


        return  dp[arr.length-1][tar];
    }
}
