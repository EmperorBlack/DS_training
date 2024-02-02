package LeetCode75.singleNumber;

public class SingleNumberDriver {
    public static void main(String[] args) {

    }
}

class Solution {
//    xor with any number is that number
//    xor with same number is 0
//    and xor is aasociative
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            ans = ans^nums[i];
        }
        return ans;

    }
}
