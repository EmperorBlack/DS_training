package LeetCode75.daillyTemperature;

import java.util.Stack;

public class BrustBallonDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length-1; i >= 0 ; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] =0;
            }else{
                result[i] = stack.peek()-i;
            }
            stack.push(i);
        }

        return result;

    }
}
