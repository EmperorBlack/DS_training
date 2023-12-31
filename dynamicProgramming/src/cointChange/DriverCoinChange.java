package cointChange;

import java.util.Arrays;

public class DriverCoinChange {
    public static void main(String[] args) {
        System.out.println(Solution.countWaysToMakeChange(new int[]{1,2,3},4));
    }
}
class Solution {

    public static long countWaysToMakeChange(int denominations[], int value){

        long dp[][] = new long[denominations.length][value+1];

//        for (long[] dps: dp) {
//            Arrays.fill(dps,-1);
//        }
        for (int i = 0; i < denominations.length; i++) {
            for (int j = 0; j <= value; j++) {
                dp[i][j] = -1;
            }
        }
        return countWays(denominations,denominations.length-1,value,dp);
    }

    public static long countWays(int dem[],int ind,int tar,long[][] dp){

        if(ind == 0){
            if(tar%dem[0] == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[ind][tar] != -1){
            return dp[ind][tar];
        }

        long take = 0;
        if(dem[ind] <= tar){
            take = countWays(dem,ind,tar-dem[ind],dp);
        }
        long notTake = countWays(dem,ind-1,tar,dp);
        return  dp[ind][tar]=take+notTake;
    }

    public static long countWaysToMakeChangeTab(int denominations[], int value){

        long dp[][] = new long[denominations.length][value+1];

        for (int i = 0; i <= value; i++) {
            if(i%denominations[0] ==0){
                dp[0][i] = 1;
            }
        }

        for (int ind = 1; ind < denominations.length; ind++) {
            for (int target = 0; target <= value; target++) {
                long take = 0;
                if(denominations[ind] <= target){
                    take = dp[ind][target-denominations[ind]];
                }
                long notTake = dp[ind-1][target];
                dp[ind][target] = take+notTake;
            }
        }
        return dp[denominations.length-1][value];

    }

}