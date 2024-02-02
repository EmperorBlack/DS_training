package dynamicProgramming.subSetSumToTarget;

import java.util.Arrays;

public class SubSetSumDriver {
    public static void main(String[] args) {

        System.out.println(Solution.subsetSumToK(5,6,new int[]{1,7,2,9,10}));
    }


}

class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.


        int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        return findSubsetSum(n-1, k,arr,dp);
    }

    public static boolean findSubsetSum(int i, int target, int arr[],int[][] dp) {

        if(i ==0){
            if(target == arr[0]){
                return true;
            }else{
                return false;
            }
        }

        if(target == arr[i]){
            return true;
        }
        if(dp[i][target] != -1){
            return dp[i][target] == 1 ? true: false;
        }


        boolean pick = false;
        if(target >= arr[i]){
            pick = findSubsetSum(i-1,target-arr[i],arr,dp);
        }
        boolean nonPick = findSubsetSum(i-1,target,arr,dp);



        dp[i][target] = (pick || nonPick) ? 1 : 0;
        return  pick || nonPick;


    }
}