package dynamicProgramming.minimumElement;

import java.util.Arrays;

public class MinimumElement {
    public static void main(String[] args) {

    }
}

class Solution{
    public static int minimumElements(int num[], int x) {

        int [][]dp = new int[num.length][x+1];
        for (int i = 0; i < dp.length; i++) {

            Arrays.fill(dp[i], -1);
        }
        int result = findMinimum(num, num.length -1,x,dp);

        if(result != Integer.MAX_VALUE){
            return result;
        }
        return -1;



    }

    public static int findMinimum(int num[] , int ind, int coin,int [][]dp){

        if(ind == 0 ){
            if(coin % num[0] == 0){
                return coin/num[0];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(coin == 0 ){
            return 0;
        }

        if(dp[ind][coin]!=-1){
            return dp[ind][coin];
        }
        int pick = Integer.MAX_VALUE;

        if(coin >= num[ind]){
            pick = findMinimum(num,ind,coin-num[ind],dp);
            if(pick != Integer.MAX_VALUE){
                pick = pick+1;
            }
        }
        int nonPick = findMinimum(num,ind-1,coin,dp);
        return dp[ind][coin] =Math.min(pick,nonPick);

    }
}
