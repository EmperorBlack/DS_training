package partitionArrayForMaxSum;

import java.util.Arrays;

public class MaxSumPartDriver {
    public static void main(String[] args) {
        System.out.println(Solution.maximumSubarray(new int[]{1,20,13,4,4,1},3));
    }
}

class Solution {
    public static int maximumSubarray(int arr[], int k) {
        // Write your code here..


        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return findMaximumSubarray(arr,k,0,dp);

    }

    public static int findMaximumSubarray(int arr[], int k, int i,int[] dp) {
        // Write your code here..

        if(i == arr.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int segMax = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(i+k,arr.length) ; j++) {
            segMax = Math.max(arr[j],segMax);
            int segSum = (1+(j-i))*segMax;

            int maxPartSum = segSum + findMaximumSubarray(arr,k,j+1,dp);

            maxSum = Math.max(maxSum,maxPartSum);

        }
        return dp[i] = maxSum;
    }
}