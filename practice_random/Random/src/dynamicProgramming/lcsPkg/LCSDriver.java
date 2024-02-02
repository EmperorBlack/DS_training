package dynamicProgramming.lcsPkg;

import java.util.Arrays;

public class LCSDriver {

    public static void main(String[] args) {

        new StringBuffer("dd").reverse().toString();

    }
}

class Solution {

    public static int lcs(String s, String t) {

        int dp[][] = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i],-1);
        }
        return findLcs(s,t,s.length()-1,t.length()-1,dp);

    }

    public static int findLcs(String s, String t, int ind1, int ind2, int dp[][]){

        if(ind1 < 0 || ind2 <0){
            return 0;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(s.charAt(ind1) == t.charAt(ind2)){
            return dp[ind1][ind2] = findLcs(s,t,ind1-1,ind2-1,dp)+1;
        }
        int first = findLcs(s,t,ind1-1,ind2,dp);
        int second = findLcs(s,t,ind1,ind2-1,dp);
        return dp[ind1][ind2] = Math.max(first,second);

    }
}
