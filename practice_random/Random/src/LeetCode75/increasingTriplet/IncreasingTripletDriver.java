package LeetCode75.increasingTriplet;

public class IncreasingTripletDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().increasingTriplet(new int[]{5,4,3,2,1}));
    }

}

class Solution {
    public boolean increasingTriplet(int[] nums) {

        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i++) {

            if(nums[i] <= small){
                small = nums[i];
            } else if (nums[i] <= middle) {
                middle= nums[i];
            }else {
                return true;
            }

        }
        return false;

    }
}