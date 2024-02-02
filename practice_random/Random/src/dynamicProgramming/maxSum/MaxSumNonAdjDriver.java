package dynamicProgramming.maxSum;

import java.util.Arrays;
import java.util.List;

public class MaxSumNonAdjDriver {
    public static void main(String[] args) {
        System.out.println(Solution.maximumNonAdjacentSum(Arrays.asList(4,8)));
    }
}


class Solution {
    public static int maximumNonAdjacentSum(List<Integer> nums) {
        int dp[] = new int[nums.size()];
        Arrays.fill(dp,-1);
        return findMax(nums,nums.size()-1,dp);


    }

    public static int findMax(List<Integer> nums, int n , int[] dp){
        if(n ==0 ){
            return nums.get(n);
        }
        if(n==1){
            return Math.max(nums.get(1),nums.get(0));
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int self = findMax(nums,n-2,dp)+nums.get(n);
        int adj = findMax(nums,n-1,dp);
        return dp[n] = Math.max(self,adj);
    }
}