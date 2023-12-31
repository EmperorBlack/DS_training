package maxSumNonAdj;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonAdjDriver {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(9);
        list.add(8);
        list.add(2);
        System.out.println(Solution.maximumNonAdjacentSum(list));

    }
}

//class Solution {
//    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//        if(nums.size() < 2){
//            return nums.get(0);
//        }
//
//        int dp[] = new int[nums.size()];
//        Arrays.fill(dp,-1);
//
//       int findN = findMaxSum(nums,nums.size()-1,dp);
//       int findAdj = findMaxSum(nums,nums.size()-2,dp);
//
//       return Math.max(findN,findAdj);
//    }
//
//    public static int findMaxSum(ArrayList<Integer> nums, int n,int dp[]){
//        if(n<2){
//            return nums.get(n);
//        }
//        if(dp[n] != -1){
//            return dp[n];
//        }
//        int max = Integer.MIN_VALUE;
//            for (int i = 2; i <= n; i++) {
//                int val = findMaxSum(nums,n-i,dp);
//                max = Math.max(max,val);
//            }
//
//        dp[n] = max+nums.get(n);
//        return dp[n];
//    }
//}
class Solution {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {


        int dp[] = new int[nums.size()];
        Arrays.fill(dp,-1);

        return findMaxSumSpace(nums,nums.size());

    }

    public static int findMaxSum(ArrayList<Integer> nums, int n,int dp[]){
        if(n==0){
            return nums.get(n);
        }
        if(n<0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int pick = nums.get(n)+findMaxSum(nums,n-2,dp);
        int nPick = findMaxSum(nums,n-1,dp);
        int max = Math.max(pick,nPick);
        dp[n] = max;
        return dp[n];
    }

    public static int findMaxSumTab(ArrayList<Integer> nums, int n,int dp[]){

        dp[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            int take = 0;
            if(i-2 >= 0){
                take = dp[i-2]+nums.get(i);
            }
            int nTake = dp[i-1];
            dp[i] = Math.max(take,nTake);

        }
        return dp[n-1];
    }

    public static int findMaxSumSpace(ArrayList<Integer> nums, int n){

        int pic = 0;
        int notPic = nums.get(0);

        for (int i = 1; i < n; i++) {

            int curr = nums.get(i) + pic;
            curr = Math.max(curr,notPic);
            pic = notPic;
            notPic = curr;

        }
        return notPic;
    }
}