package LeetCode75.astroidCollide;

import java.util.Stack;

public class AstroidCollideDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {

            if(asteroids[i] >= 0 ){
                stack.push(asteroids[i]);
            }else{
                int value = -(asteroids[i]);
                while(!stack.isEmpty() && stack.peek() >= 0 && stack.peek() < value){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == value){
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }

            }
        }
        int result[] = new int[stack.size()];
        for (int i = result.length-1; i >=0 ; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
