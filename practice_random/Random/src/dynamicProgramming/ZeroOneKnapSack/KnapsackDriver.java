package dynamicProgramming.ZeroOneKnapSack;


import java.util.Arrays;

public class KnapsackDriver {
    public static void main(String[] args) {

    }
}

class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int dp[][] = new int[n][maxWeight+1];
        for (int i = 0; i < dp.length; i++) {

            Arrays.fill(dp,-1);
        }
        return findMax(weight,value,n-1,maxWeight,dp);


    }

    static int findMax(int[] weight, int[] value, int ind, int maxWeight,int[][] dp){

        if(maxWeight == 0){
            return 0;
        }

        if(ind == 0){
            if(weight[ind] <= maxWeight){
                return value[ind];
            }else{
                return 0;
            }
        }

        int pick = 0;
        if(weight[ind] <= maxWeight ){
            pick = findMax(weight,value,ind-1,maxWeight-weight[ind],dp)+value[ind];
        }
        int nonPick = findMax(weight,value,ind-1,maxWeight,dp);

        return dp[ind][maxWeight] = Math.max(pick,nonPick);

    }
}
