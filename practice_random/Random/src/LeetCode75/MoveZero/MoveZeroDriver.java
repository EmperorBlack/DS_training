package LeetCode75.MoveZero;

import java.util.Arrays;

public class MoveZeroDriver {
    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{1});
    }

}

class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0;
        int j = 0;

        for (int k = 0; k < nums.length; k++) {

            if(nums[k]!= 0){
                nums[i] = nums[k];
                i++;
            } else if (nums[j]!= 0 && i == j) {
                i++;j++;
            } else if (nums[j] == 0) {
                j++;
            }

        }
        while (i < nums.length){
            nums[i] = 0;
            i++;
        }

    }
}
