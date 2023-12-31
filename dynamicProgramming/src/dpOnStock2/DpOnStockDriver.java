package dpOnStock2;

public class DpOnStockDriver {
    public static void main(String[] args) {

    }
}
class Solution {
    public static long getMaximumProfit (int n, long[] values) {
        long dp[][] = new long[values.length][2];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return findMaxProfit(values,0,1,dp);
        // Your code goes here.
    }

    public static long findMaxProfit(long[] values,int ind, int buy, long [][]dp){
        if(ind == values.length){
            return 0;
        }

        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        long profit  = 0l;
        if(buy == 1){

            profit = Math.max((findMaxProfit(values,ind+1,0,dp)-values[ind]),findMaxProfit(values,ind+1,1,dp));

        }else{

            profit = Math.max((values[ind]+findMaxProfit(values,ind+1,1,dp)),findMaxProfit(values,ind+1,0,dp));
        }
        return dp[ind][buy] = profit;
    }

    public static long getMaximumProfitTab (int n, long[] values) {
        long dp[][] = new long[values.length+1][2];

       dp[values.length][0] = dp[values.length][1] = 0;

        for (int i = values.length-1; i >=0 ; i--) {
            for (int j = 0; j < 2; j++) {
                long profit = 0l;
                if(j == 1){

                    profit = Math.max(dp[i+1][0]-values[i],dp[i+1][1]);
                }else{
                    profit = Math.max(dp[i+1][1]+values[i],dp[i+1][0]);
                }

                dp[i][j] = profit;
            }

        }
        return dp[0][1];
        // Your code goes here.
    }
}
