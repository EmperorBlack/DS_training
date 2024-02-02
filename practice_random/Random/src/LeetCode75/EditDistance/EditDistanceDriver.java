package LeetCode75.EditDistance;

import java.util.Arrays;

public class EditDistanceDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minDistance(String word1, String word2) {

        int dp[][] = new int[word1.length()][word2.length()];
        for (int a[]: dp
             ) {
            Arrays.fill(a,-1);
        }
        return findMinDistance(word1,word2,word1.length()-1,word2.length()-1,dp);

    }

    public int findMinDistance(String word1, String word2,int i, int j,int[][] dp) {

        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }


        int minValue = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            minValue = findMinDistance(word1,word2,i-1,j-1,dp);
        }else{
            int delete = findMinDistance(word1,word2,i-1,j,dp)+1;
            int replace = findMinDistance(word1,word2,i-1,j-1,dp)+1;
            int insert = findMinDistance(word1,word2,i,j-1,dp)+1;
            minValue = Math.min(Math.min(delete,replace),insert);
        }
        return dp[i][j] = minValue;

    }
}
