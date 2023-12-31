package subsequences;

import java.util.ArrayList;
import java.util.List;

public class DistinctSubsequencesDriver {
    public static void main(String[] args) {
        System.out.println(Solution.distinctSubsequences("aaa","a"));
        System.out.println(Solution.distinctSubsequencesTab("aaa","a"));
    }
}

class Solution{

    static int prime = (int) (Math.pow(10, 9) + 7);

    public static List<String> subsequences(String str){

        List<String> result = new ArrayList<>();
        findSubsequences(str,result,"",str.length()-1);

        System.out.println(result);
        return result;

    }

    public static void findSubsequences(String str,List<String> result,String subSeq,int ind){

        if(ind < 0){
            result.add(subSeq);
            return;
        }
//        choose index
        findSubsequences(str,result,str.charAt(ind)+subSeq,ind-1);
        findSubsequences(str,result,subSeq,ind-1);
    }

    public static int distinctSubsequences(String str, String sub) {
        int dp[][] = new int[str.length()][sub.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < sub.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return findDistinctSubsequences(str,sub,str.length()-1,sub.length()-1,dp);
        // Write your code here.
    }

    public static int findDistinctSubsequences(String str, String sub,int ind1, int ind2, int dp[][]) {

        if(ind2 < 0){
            return 1;
        }
        if(ind1 < 0){
            return 0;
        }


        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(str.charAt(ind1) == sub.charAt(ind2)){
            return dp[ind1][ind2] = (findDistinctSubsequences(str, sub, ind1-1, ind2-1,dp) + findDistinctSubsequences(str, sub, ind1-1, ind2,dp))%prime;
        }else{
            return dp[ind1][ind2] = findDistinctSubsequences(str, sub, ind1-1, ind2,dp);
        }
    }

    public static int distinctSubsequencesTab(String str, String sub) {
        int dp[][] = new int[str.length()+1][sub.length()+1];

        for (int i = 0; i < str.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= sub.length(); j++) {
                if(str.charAt(i-1) == sub.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j-1] +  dp[i-1][j])%prime;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[str.length()][sub.length()];
    }
}