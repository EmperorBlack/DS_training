package minCoinCount;

import java.util.Arrays;

public class MinimumElementDriver {

    public static void main(String[] args) {

        System.out.println(Solution.minimumElements(new int[]{17,10,5},6));
    }
}

class Solution {
    public static int minimumElements(int num[], int x) {
        int dp[][] = new int[num.length][x+1];
        for(int i = 0; i< num.length;i++){
            Arrays.fill(dp[i],-1);
        }
        // Write your code here..
        int min = findMinimumcEle(dp,num,num.length-1,x);
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;


    }

    public static int findMinimumcEle(int dp[][],int num[],int ind, int target){

        if(ind == 0 ){
            if(target % num[0] ==0){
                return target/num[0];
            }
            return Integer.MAX_VALUE;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }

        int take = Integer.MAX_VALUE;
        if(num[ind] <= target){
            int min = findMinimumcEle(dp,num,ind,target-num[ind]);
            if(min == Integer.MAX_VALUE){
                take = Integer.MAX_VALUE;
            }else{
                take = 1+min;
            }
        }
        int notTake = 0+ findMinimumcEle(dp,num,ind-1,target);
        return dp[ind][target]=Math.min(take,notTake);
    }

    public static int minimumElementsTab(int num[], int x) {
        int dp[][] = new int[num.length][x+1];
        for(int i = 0; i< num.length;i++){
            Arrays.fill(dp[i],-1);
        }

        for (int i = 0; i < x; i++) {
            if(i%num[0] == 0){
                dp[0][i] = i/num[0];
            }else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int ind = 1; ind < num.length; ind++) {
            for (int tar = 0; tar <= x; tar++) {
                int take = Integer.MAX_VALUE;
                if(num[ind] <= tar){
                    int min = dp[ind][tar-num[ind]];
                    if(min == Integer.MAX_VALUE){
                        take = Integer.MAX_VALUE;
                    }else{
                        take = 1+min;
                    }
                }
                int notTake = dp[ind-1][tar];
                dp[ind][tar] = Math.min(take,notTake);
            }
        }
        int ans = dp[num.length-1][x];
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;


    }

}