package longestSubsequenceString;


public class LongestCommSubsequenceDriver {

    public static void main(String[] args) {

        System.out.println(Solution.lcsStringTab("brute","groot"));

    }


}
class Solution{
    public static String lcsStringTab(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1];

        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {

                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }
        int ind1 = s.length();
        int ind2 = t.length();
        String result = "";
        while(ind1 > 0 && ind2 > 0){
            if(s.charAt(ind1-1) == t.charAt(ind2-1)){
                result = s.charAt(ind1-1)+result;
                ind1--;
                ind2--;
            }else{
                if(dp[ind1-1][ind2] > dp[ind1][ind2-1]){
                    ind1--;
                }else{
                    ind2--;
                }
            }
        }
        return result;
    }
}
