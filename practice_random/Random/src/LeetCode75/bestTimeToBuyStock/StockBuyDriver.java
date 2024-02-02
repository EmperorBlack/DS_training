package LeetCode75.bestTimeToBuyStock;

import java.util.Arrays;

public class StockBuyDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {

        int dp[][] = new int[prices.length][2];
        for (int a[] : dp
             ) {
            Arrays.fill(a,-1);
        }
        return findMaxProfit(prices,fee,0,1,dp);



    }

    public int findMaxProfit(int[] prices, int fee,int ind,int buy, int[][] dp) {

        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] !=-1){
            return dp[ind][buy];
        }

        int value =0;
        if(buy == 1){
            value = Math.max((findMaxProfit(prices,fee,ind+1,0,dp)-prices[ind]),findMaxProfit(prices,fee,ind+1,1,dp));
        }else{
            value = Math.max((findMaxProfit(prices,fee,ind+1,1,dp)+prices[ind]-fee),findMaxProfit(prices,fee,ind+1,0,dp));
        }

        return dp[ind][buy] = value;


    }
}
