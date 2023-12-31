package wildCardMatch;

public class WildCardMatchingDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public static boolean wildcardMatching(String pattern, String text) {
        int dp[][] = new int[pattern.length()][text.length()];
        for (int i = 0; i < pattern.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return doWildcardMatching(pattern,text,pattern.length()-1,text.length()-1,dp);
    }
    public static boolean doWildcardMatching(String pattern, String text,int i, int j, int dp[][]) {

        if(i<0 && j < 0){
            return true;
        }
        if(i<0 && j >= 0){
            return false;
        }
        if(i>=0 && j < 0){
            for (int k = 0; k <= i; k++) {
                if(pattern.charAt(k) != '*'){
                    return false;
                }
            }
            return true;


        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1 ? true : false;
        }

        if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?'){
            boolean result = doWildcardMatching(pattern,text,i-1,j-1,dp);
            dp[i][j] = result ? 1 : 0;
            return  result ;
        }
        if (pattern.charAt(i) == '*') {
            boolean result = doWildcardMatching(pattern,text,i-1,j,dp) || doWildcardMatching(pattern,text,i,j-1,dp);
            dp[i][j] = result ? 1 : 0;
            return result;
        }
        return false;
    }

    public static boolean wildcardMatchingTab(String pattern, String text) {
        boolean dp[][] = new boolean[pattern.length()+1][text.length()+1];

        dp[0][0] = true;

        for (int i = 1; i <= pattern.length(); i++) {

            boolean isTrue = true;
            for (int ii = 0; ii < i; ii++) {
                if(pattern.charAt(ii) != '*'){
                    isTrue = false;
                    break;
                }
            }
           dp[i][0] = isTrue;

        }


        for (int i = 1; i <= pattern.length(); i++) {

            for (int j = 1; j <= text.length(); j++) {

                if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(i-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }

        }
        return dp[pattern.length()][text.length()];
    }

}

