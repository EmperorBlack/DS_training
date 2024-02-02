package LeetCode75.nthTribonanci;

import java.util.Arrays;

public class TribonanciDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(4));

    }
}

class Solution {
    public int tribonacci(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return findTribonanci(n,dp);


    }

    public int findTribonanci(int n,int[] dp){

        if(n<1){
            return 0;
        }
        if(n<3){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = findTribonanci(n-1,dp)+findTribonanci(n-2,dp)+findTribonanci(n-3,dp);
    }
}
