package LeetCode75.productofArray;

import java.util.Arrays;

public class ProductOfArrayDriver {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1,2,3,4})));

    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {


        int[] forward = new int[nums.length];
        int[] reverse = new int[nums.length];
        int[] result = new int[nums.length];

        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            forward[i] = prod;
        }

        int rev = 1;
        for (int i = nums.length-1; i >=0; i--) {
            rev = rev * nums[i];
            reverse[i] = rev;
        }

        for (int i = 0; i < nums.length; i++) {

            int tillBack = 1;
            int tillFor =1;

            if(i>0){
                tillBack = forward[i-1];
            }
            if(i< nums.length-1){
                tillFor = reverse[i+1];
            }
            result[i] = tillBack * tillFor;


        }
        return result;
    }
}


