package partionSumMinAbsDifferenc;

public class  partitionMinAbsDifferenceDriver {
    public static void main(String[] args) {
        System.out.println(Solution.minSubsetSumDifference(new int[]{1,2,3,4},4));
    }
}

class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.

        int totalSum  = 0;
        for (int a :arr
             ) {
            totalSum+=a;
        }

        int k = totalSum;
        boolean dp[][] = new boolean[n][k+1];
        for (int i = 0; i <n ; i++) {
            dp[i][0] = true;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <=k ; target++) {

                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(arr[ind] <= target){
                    take = dp[ind-1][target-arr[ind]];
                }
                dp[ind][target] = take||notTake;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum/2; s1++) {

            if(dp[n-1][s1] == true){
                int s2 = totalSum - s1;
                if(min > Math.abs(s1-s2)){
                    min = Math.abs(s1-s2);
                }
            }
        }
        return min;

    }
}
