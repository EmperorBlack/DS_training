package LeetCode75.climbingStaires;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(new Solution().minCostClimbingStairs(new int[]{10,15,20}));

    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);

        return Math.min(calculateMinost(cost,cost.length-1,dp),calculateMinost(cost,cost.length-2,dp));

    }

    public int calculateMinost(int[] cost, int ind,int[] dp){

        if(ind < 2){
            return cost[ind];
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int twoStep = calculateMinost(cost,ind-2,dp);
        int oneStep = calculateMinost(cost,ind-1,dp);
        return dp[ind] =Math.min(twoStep,oneStep)+cost[ind];



    }

    public int minCostClimbingStairs2(int[] cost) {

        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];

        for (int ind = 1; ind <= cost.length; ind++) {
            int curr = ind >= cost.length ? 0 : cost[ind];
            int twoStep = (ind-2 <0 ? 0:dp[ind-2])+curr;
            int oneStep = dp[ind-1]+curr;
            dp[ind] = Math.min(twoStep,oneStep);
        }

        return dp[cost.length];



    }


}
