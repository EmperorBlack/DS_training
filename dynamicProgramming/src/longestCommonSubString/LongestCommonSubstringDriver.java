package longestCommonSubString;

public class LongestCommonSubstringDriver {
    public static void main(String[] args) {
        System.out.println(Solution.lcs("yxxzzxxxx","yzyzxxyxxz"));
    }
}

class Solution {

    static int max = 0;

    public static int lcs(String s, String t) {
        max = 0;
        int dp[][] = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        findLongestSubSequence(s,t,s.length()-1,t.length()-1,dp);
        return max;
    }

    public static int findLongestSubSequence(String s1, String s2, int ind1, int ind2,int[][] dp){

        if(ind1 < 0 || ind2 < 0){
            return 0;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        int maxTill = 0;
        if(s1.charAt(ind1) == s2.charAt(ind2)){

             maxTill = 1+findLongestSubSequence(s1,s2,ind1-1,ind2-1,dp);
            if(max < maxTill){
                max = maxTill;
            }
        }

         findLongestSubSequence(s1,s2,ind1-1,ind2,dp);
        findLongestSubSequence(s1,s2,ind1,ind2-1,dp);
        return dp[ind1][ind2] = maxTill;

    }

    public static int lcsTab(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1];

        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = 0;
        }

        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {

                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(dp[i][j] > max){
                        max = dp[i][j];
                    }
                }else{
                    dp[i][j] = 0;
                }

            }
        }
        return max;
    }

}
