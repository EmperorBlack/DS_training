package LeetCode75.houseRobber;

import java.util.Arrays;

public class HouseRobberDriver {
    public static void main(String[] args) {

    }
}


class Solution {
    public int rob(int[] nums) {

        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return findMax(nums,nums.length-1,dp);

    }

    public int findMax(int[] nums,int ind,int[] dp){

        if(ind ==0){
            return nums[0];
        }

        if(ind ==1){
            return Math.max(nums[0],nums[1] );
        }

        if(dp[ind]!= -1){
            return dp[ind];
        }

        int choose = findMax(nums,ind-2,dp)+nums[ind];
        int notChoose = findMax(nums,ind-1,dp);
        return dp[ind] = Math.max(choose,notChoose);
    }
}