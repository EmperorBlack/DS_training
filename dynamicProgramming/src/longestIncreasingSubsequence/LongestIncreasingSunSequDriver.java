package longestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSunSequDriver {
    public static void main(String[] args) {

        System.out.println(Solution.printLongestIncreasingSubsequenceTab2(new int[]{5,4,11,1,16,8}));
    }
}


class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {

        int dp[][] = new int[arr.length][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length+1; j++) {
                dp[i][j] = -1;
            }
        }
        return findLongestIncSub(arr,0,-1,dp);
    }

    public static int findLongestIncSub(int arr[],int ind, int prv,int[][] dp){

        if(ind == arr.length){
            return 0;
        }

        if(dp[ind][prv+1] != -1){
            return dp[ind][prv+1];
        }

        int take = 0;
        int notTake = findLongestIncSub(arr, ind+1,prv,dp);
        if(prv ==-1 || arr[prv] < arr[ind]){
            take = 1+findLongestIncSub(arr,ind+1,ind, dp);
        }
        return dp[ind][prv+1] = Math.max(take,notTake);




    }

    public static int longestIncreasingSubsequenceTab(int arr[]) {

        int dp[][] = new int[arr.length+1][arr.length+1];

        for (int i = arr.length-1; i >= 0 ; i--) {
            for (int j = i-1; j >= -1; j--) {
                int take = 0;
                int notTake = dp[i+1][j+1];
                if(j ==  -1 || arr[j] < arr[i]){
                    take = 1+dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(take,notTake);
            }
        }



        return dp[0][0];
    }

    public static int printLongestIncreasingSubsequenceTab2(int arr[]) {

        int dp[] = new int[arr.length];
        int hash[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            hash[i] = -1;
        }
        int maxSeq = 0;
        int maxSeqInd = -1;
        for (int i = 0; i < arr.length; i++) {

            int max = 1;
            int prv_seq = -1;
            for (int j = 0; j < i; j++) {

                if(arr[j] < arr[i]){
                    int seq = dp[j] + dp[i];
                    if(max < seq){
                        prv_seq = j;
                        max = seq;
                    }
                }
            }
            dp[i] = max;
            hash[i] = prv_seq;
            if(maxSeq < max){
                maxSeq = max;
                maxSeqInd = i;
            }
        }
        int k = maxSeqInd;
        while(k >=0){
            System.out.println(arr[k]);
            k = hash[k];
        }
        return 0;
    }

    public static int LongestIncreasingSubsequenceTab2(int arr[]) {

        int dp[] = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            dp[i] = 1;
//        }
        Arrays.fill(dp,1);
        int maxSeq = 0;
        for (int i = 0; i < arr.length; i++) {

            int max = 1;
            for (int j = 0; j < i; j++) {

                if(arr[j] < arr[i]){
                    int seq = dp[j] + dp[i];
                    max = Math.max(max,seq);
                }
            }
            dp[i] = max;
            maxSeq = Math.max(maxSeq,max);
        }
        return maxSeq;
    }

    public static int longestIncreasingSubsequenceBS(int arr[]) {


     List<Integer> temp = new ArrayList<>();
     temp.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            if(arr[i] > temp.get(temp.size()-1)){
                temp.add(arr[i]);
            }else{
                int ind = Collections.binarySearch(temp,arr[i]);
                if(ind ==-1){
                    ind = 0;
                }
                temp.set(ind,arr[i]);
            }
        }
        return temp.size();
    }


}