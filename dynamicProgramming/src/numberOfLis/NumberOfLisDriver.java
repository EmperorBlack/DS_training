package numberOfLis;

import java.util.Arrays;

public class NumberOfLisDriver {
    public static void main(String[] args) {
        System.out.println(Solution.findNumberOfLIS(new int[]{5,7,2,3}));
    }
}

class Solution {
    public static int findNumberOfLIS(int []arr) {
        int dp[] = new int[arr.length];
        int noOfLis[] = new int[arr.length];
        Arrays.fill(dp,1);
        Arrays.fill(noOfLis,1);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    noOfLis[i] = noOfLis[j];
                } else if (arr[j] < arr[i] && dp[j]+1 == dp[i]) {
                    noOfLis[i] = noOfLis[j]+noOfLis[i];
                }
            }
           max = Math.max(max,dp[i]);
        }
        int noOfSeq = 0;
        for (int i = 0; i < noOfLis.length; i++) {
            if(dp[i] == max){
                noOfSeq += noOfLis[i];
            }
        }
        return noOfSeq;
    }
}
