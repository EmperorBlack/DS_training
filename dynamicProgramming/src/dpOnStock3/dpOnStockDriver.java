package dpOnStock3;

public class dpOnStockDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int maxProfit(int []prices, int n) {
        int dp[][][] = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }

            }
        }
        return findMaxProfit(prices,0,1,dp,2);
        // Your code goes here.
    }

    public static int findMaxProfit(int[] prices,int ind, int buy, int [][][]dp,int sell){
        if(ind == prices.length || sell == 0){
            return 0;
        }

        if(dp[ind][buy][sell] != -1){
            return dp[ind][buy][sell];
        }
        int profit  = 0;
        if(buy == 1){

            profit = Math.max((findMaxProfit(prices,ind+1,0,dp,sell)-prices[ind]),findMaxProfit(prices,ind+1,1,dp,sell));

        }else{

            profit = Math.max((prices[ind]+findMaxProfit(prices,ind+1,1,dp,sell-1)),findMaxProfit(prices,ind+1,0,dp,sell));
        }
        return dp[ind][buy][sell] = profit;
    }

    public static int maxProfitTab(int []prices) {
        int dp[][][] = new int[prices.length+1][2][3];


        for (int i = prices.length-1; i >=0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    int profit = 0;
                    if(j == 1){

                        profit = Math.max(dp[i+1][0][k]-prices[i],dp[i+1][1][k]);
                    }else{
                        profit = Math.max(dp[i+1][1][k-1]+prices[i],dp[i+1][0][k]);
                    }

                    dp[i][j][k] = profit;

                }
            }
        }

        return dp[0][1][2];
        // Your code goes here.
    }
}
