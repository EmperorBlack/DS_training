package minCostToCutTree;

import java.util.Arrays;

public class MinCostToCutTheTree {
    public static void main(String[] args) {
//        System.out.println(Solution.cost(10,4,new int[]{1,3 ,4, 7}));
        System.out.println(Solution.costTab(10,4,new int[]{1,3,4,7}));
    }
}

class Solution {
    public static int cost(int n, int c, int cuts[]) {

        // Write your code here..
        int[] mCuts = new int[c+2];
        mCuts[c+1] = n;
        for (int i = 1; i <=c ; i++) {
            mCuts[i] = cuts[i-1];
        }

        Arrays.sort(mCuts);
       int  dp[][] = new int[c+1][c+1];
        for (int[] d:dp
             ) {
            Arrays.fill(d,-1);
        }
        return getMiniCuts(1,c,mCuts,dp);
    }

    public static int getMiniCuts(int i,int j,int cuts[],int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int costs = (cuts[j+1]-cuts[i-1]) + getMiniCuts(i,k-1,cuts,dp) + getMiniCuts(k+1,j,cuts,dp);
            min = Math.min(min,costs);
        }
        return dp[i][j] = min;
    }

    public static int costTab(int n, int c, int cuts[]) {


        int  dp[][] = new int[c+2][c+2];

        // Write your code here..
        int[] mCuts = new int[c+2];
        mCuts[c+1] = n;
        for (int i = 1; i <=c ; i++) {
            mCuts[i] = cuts[i-1];
        }
        Arrays.sort(mCuts);

        for (int i = c; i >= 1; i--) {
            for (int j = i; j <=c  ; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int costs = (mCuts[j+1]-mCuts[i-1]) + dp[i][k-1] +dp[k+1][j];
                    min = Math.min(min,costs);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][c];
    }

}
