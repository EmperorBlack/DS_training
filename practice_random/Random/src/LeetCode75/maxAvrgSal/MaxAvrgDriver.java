package LeetCode75.maxAvrgSal;

public class MaxAvrgDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{-1},1));
    }

}

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double maxAvg = Integer.MIN_VALUE;
        double sum = 0d;
        for (int i = 0; i < nums.length; i++) {

            sum = sum+nums[i];
            if(i >= k-1){
                double avg = sum/k;
                if(avg > maxAvg){
                    maxAvg = avg;
                }
                sum = sum - nums[i-(k-1)];
            }
        }

        return maxAvg;

    }

}
