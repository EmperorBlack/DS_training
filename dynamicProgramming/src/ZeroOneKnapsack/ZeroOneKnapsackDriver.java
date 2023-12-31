package ZeroOneKnapsack;

import java.util.Arrays;

public class ZeroOneKnapsackDriver {
    public static void main(String[] args) {

    }
}


class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         *
         */
//        int dp[][] = new int[n][maxWeight+1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i],-1);
//        }
//        return findMax(weight,value,n-1,maxWeight,dp);
        return findMaxTab(weight,value,maxWeight,n-1);

    }

    static int findMax(int[] weight, int[] value, int ind, int maxWeight,int[][] dp){
        if(maxWeight == 0){
            return 0;
        }

        if(ind == 0 ){
                if(maxWeight >= weight[0])
                    return value[0];
                else{
                    return 0;
                }
        }
        if(dp[ind][maxWeight] !=-1){
            return dp[ind][maxWeight];
        }

        int pick = Integer.MIN_VALUE;
        if(maxWeight>= weight[ind]){
            pick = findMax(weight,value,ind-1,maxWeight-weight[ind],dp)+value[ind];
        }
        int nonPick = findMax(weight,value,ind-1,maxWeight,dp);
        return dp[ind][maxWeight] = Math.max(pick,nonPick);
    }

    static int findMaxTab(int[] weight, int[] value, int maxWeight,int n){


        int dp[][] = new int[n][maxWeight+1];

        for (int i = 0; i <= maxWeight; i++) {
            if(weight[0] <= i){
                dp[0][i] = value[0];
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= maxWeight; cap++) {
                int pick = Integer.MIN_VALUE;

                if(cap >= weight[ind]){
                    pick = value[ind]+dp[ind-1][cap-weight[ind]];
                }
                int nonPick = dp[ind-1][cap];
                dp[ind][cap] = Math.max(pick,nonPick);
            }
        }


        return dp[n-1][maxWeight];
    }

}
