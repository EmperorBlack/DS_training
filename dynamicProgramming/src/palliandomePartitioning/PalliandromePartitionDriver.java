package palliandomePartitioning;

import java.util.Arrays;

public class PalliandromePartitionDriver {
    public static void main(String[] args) {
        System.out.println(Solution.palindromePartitioning("ccb"));
    }
}

class Solution {
    public static int palindromePartitioning(String str) {
        int dp[] = new int[str.length()];
        Arrays.fill(dp,-1);
        return doPalindromePartitioning(str,0,dp)-1;
    }

    public static int doPalindromePartitioning(String str,int i,int[] dp) {
        if(i == str.length()){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        StringBuffer sb = new StringBuffer("");
        int min = Integer.MAX_VALUE;
        for (int j = i; j < str.length() ; j++) {
            sb.append(str.charAt(j));
            if(isPalliandrome(sb)){
                int partCount  = 1+doPalindromePartitioning(str,j+1,dp);
                min = Math.min(min,partCount);
            }
        }
        return dp[i] = min;
    }

    public static boolean isPalliandrome(StringBuffer sb){
        String temp = sb.toString();
        StringBuffer sbClone = new StringBuffer(temp);
        return temp.equals(sbClone.reverse().toString());
    }
}
