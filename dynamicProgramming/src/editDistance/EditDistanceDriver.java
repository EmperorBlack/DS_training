package editDistance;

import java.util.Arrays;

public class EditDistanceDriver {
    public static void main(String[] args) {
        Solution.editDistanceTab("abc","dc");
    }
}


class Solution {

    public static int editDistance(String str1, String str2) {

        int dp[][] = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return findEditDistance(str1,str2,str1.length()-1,str2.length()-1,dp);


    }

    public static int findEditDistance(String s1, String s2, int i, int j,int[][] dp){

        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = findEditDistance(s1,s2,i-1,j-1,dp);
        }else {
            int delete = 1+findEditDistance(s1,s2,i-1,j,dp);
            int insert = 1+findEditDistance(s1,s2,i,j-1,dp);
            int replace = 1+findEditDistance(s1,s2,i-1,j-1,dp);
            return dp[i][j] = Math.min(delete,Math.min(insert,replace));
        }
    }

    public static int editDistanceTab(String str1, String str2) {

        int dp[][] = new int[str1.length()+1][str2.length()+1];

        for (int j = 0; j <= str2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                     dp[i][j] = dp[i-1][j-1];
                }else {
                    int delete = 1+dp[i-1][j];
                    int insert = 1+dp[i][j-1];
                    int replace = 1+dp[i-1][j-1];
                     dp[i][j] = Math.min(delete,Math.min(insert,replace));
                }
            }
        }

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length() ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[str1.length()][str2.length()];


    }
}