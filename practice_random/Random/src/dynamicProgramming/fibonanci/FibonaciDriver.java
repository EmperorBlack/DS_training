package dynamicProgramming.fibonanci;

import java.util.Arrays;

public class FibonaciDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int fib(int n) {


        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return findFibonaci(n, dp);


    }

    public static int findFibonaci(int n, int[] dp){

        if(n < 2){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = findFibonaci(n-1,dp)+findFibonaci(n-2,dp);

    }
}
