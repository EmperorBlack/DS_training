package LongestStringChain;

import java.util.Arrays;

public class LongestStringChainDrier {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int longestStrChain(String[] arr) {
        Arrays.sort(arr,(o1, o2) -> o1.length()-o2.length());
        int dp[] = new int[arr.length];
        Arrays.fill(dp,1);
        int maxSeq = 0;
        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {

                if(isAChain(arr[i],arr[j]) && dp[j]+1 > dp[i]){
                   dp[i] = 1+dp[j];
                }
            }
            maxSeq = Math.max(maxSeq,dp[i]);
        }
        return maxSeq;
    }

    public static boolean isAChain(String s1, String s2){

        if(s1.length() != s2.length()+1){
            return false;
        }

        int i =0,j =0;

        while (i < s1.length()){

            if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }

        }
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        return false;


    }
}