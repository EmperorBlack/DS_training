package LeetCode75.maxConsecutive;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxConsecutive {
    public static void main(String[] args) {

        System.out.println(new Solution().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},2));
    }
}

class Solution {
    public int longestOnes(int[] nums, int k) {

        int max = 0;


        Queue<Integer> queue = new ArrayDeque<>();

        int count =0;
        for (int i = 0; i < nums.length; i++) {
           queue.offer(nums[i]);
           if(nums[i] == 0){
               count++;
               if(count > k){
                   while(queue.poll() != 0){

                   }
                   count--;
               }
           }

           if(max < queue.size()){
               max = queue.size();
           }

        }
        return max;
    }


    public int longestOnes1(int[] nums, int k) {


        int start =0;
        int end =0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            end++;
            if(nums[i] == 0){
                zeroCount++;
            }
            if(zeroCount > 2){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
        }
        return end-start;


    }

    public int longestSubarray(int[] nums) {
        int start =0;
        int end =0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            end++;
            if(nums[i] == 0){
                zeroCount++;
            }
            if(zeroCount > 1){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
        }
        return end-start-1;

    }
}
