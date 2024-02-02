package LeetCode75.FindPivotIndex;

public class PivotIndexDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().pivotIndex(new int[]{2,1,-1}));
    }
}


class Solution {
    public int pivotIndex(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1]+nums[i];
        }

        right[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0 ; i--) {
            right[i] = nums[i] + right[i+1];
        }

        for (int i = 0; i < nums.length; i++) {

            int leftV = i > 0 ? left[i-1] : 0;
            int rightV =i < nums.length-1 ? right[i+1]: 0;

            if(leftV == rightV){
                return i;
            }
        }
        return -1;
    }
}
