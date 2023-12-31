package frogJumps;

import java.util.Arrays;

public class FrogJumpsDriver {
    public static void main(String[] args) {


        System.out.println(Solution.frogJump(4,new int[]{10,20,30,10}));


    }
}

class Solution {
    public static int frogJump(int n, int heights[]) {


        int dp[] = new int[n];
        Arrays.fill(dp,-1);
//        return frogJumpRec(n-1,heights,dp);
//        return frogJumpTab(n,heights);
//        return frogJumpSpace(n,heights);
        return frogJumpKRec(n-1,heights,dp,3);
    }

    public static int frogJumpRec(int n, int heights[],int[] dp) {

        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int right = Integer.MAX_VALUE;
        int left = frogJumpRec(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]);
        if(n>1)
            right = frogJumpRec(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);
        int min = Math.min(left,right);
        dp[n] = min;
        return min;
    }

    public static int frogJumpTab(int n, int heights[]) {


        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = 0;


        for (int i = 1; i < n; i++) {

            int right = Integer.MAX_VALUE;
            int left =  dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            if(i>1){
                right = dp[i-2]+ Math.abs((heights[i]-heights[i-2]));
            }
            int min = Math.min(left,right);
            dp[i] = min;
        }
        return dp[n-1];

    }

    public static int frogJumpSpace(int n, int heights[]) {

        int prv1 = 0;
        int prv2 = 0;
        int right = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {

           int left = prv1 + Math.abs(heights[i]-heights[i-1]);
           if(i > 1){
               right = prv2 + Math.abs(heights[i]-heights[i-2]);
           }
           int min = Math.min(left,right);
           prv2 = prv1;
           prv1 = min;
        }
        return prv1;
    }

    public static int frogJumpKRec(int n, int heights[],int[] dp, int k) {

        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int upto = Math.min(n,k);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= upto; i++) {
            int val = frogJumpKRec(n-i,heights,dp,k)+Math.abs(heights[n]-heights[n-i]);
            min = Math.min(min,val);
        }
        dp[n] = min;
        return min;
    }



}
