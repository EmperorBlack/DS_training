package dynamicProgramming.frogJump;

import java.util.Arrays;

public class FrogJumpDriver {
    public static void main(String[] args) {

        System.out.println(Solution.frogJump(4,new int[]{10,20,30,10}));

    }
}
class Solution {
    public static int frogJump(int n, int heights[]) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return calFrogJump(n-1,heights,dp);

    }

    public static int calFrogJump(int n, int heights[],int[] dp){

        if(n==0){
            return 0;
        }
        if(n==1){
            return Math.abs(heights[0]-heights[1]);
        }

        int left = calFrogJump(n-1,heights,dp) + Math.abs(heights[n]-heights[n-1]);
        int right = calFrogJump(n-2,heights,dp) + Math.abs(heights[n]-heights[n-2]);

        return Math.min(left,right);

    }


    public static int calFrogJumpStr(int n, int heights[],int[] dp){

        if(n==0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = calFrogJump(n-2,heights,dp) + Math.abs(heights[n]-heights[n-2]);
        }
        int left = calFrogJump(n-1,heights,dp) + Math.abs(heights[n]-heights[n-1]);


        return dp[n] = Math.min(left,right);

    }
}

