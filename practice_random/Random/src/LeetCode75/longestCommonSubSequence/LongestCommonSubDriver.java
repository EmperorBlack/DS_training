package LeetCode75.longestCommonSubSequence;

import java.util.Arrays;

public class LongestCommonSubDriver {
    public static void main(String[] args) {

    }
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for (int[] arr: dp
        ) {
            Arrays.fill(arr,-1);
        }

        return findLongestCommonSubsequence(text1,text2,text1.length()-1,text2.length()-1,dp);

    }

    public int findLongestCommonSubsequence(String text1, String text2,int i,int j, int[][] dp) {

        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1+findLongestCommonSubsequence(text1, text2, i-1, j-1, dp);
        }else{
            return dp[i][j] = Math.max(findLongestCommonSubsequence(text1, text2, i-1, j, dp),findLongestCommonSubsequence(text1, text2, i, j-1, dp));
        }
    }

    public int longestCommonSubsequenceTab(String text1, String text2) {
        int m = text1.length()+1;
        int n = text2.length()+1;
        int dp[][] = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[m-1][n-1];


    }
}

