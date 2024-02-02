package LeetCode75.removeStar;

import java.util.Stack;

public class RemoveStarDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e"));
    }
}

class Solution {
    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        String result = "";
        int count = 0;
        while (!stack.isEmpty()){
            if(stack.peek()!='*'){
                result = stack.pop()+result;
            }else{
                while (!stack.isEmpty() && stack.peek()=='*'){
                    stack.pop();
                    count++;
                }
                while(!stack.isEmpty() && count >0 && stack.peek()!='*'){
                    stack.pop();
                    count--;
                }
            }
        }
        return result;
    }

    public String removeStars1(String s) {

        String result = "";
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i) == '*'){
                 if(s.length() > 0){
                     result = result.substring(0,result.length());
                 }
             }else{
                 result = result+s.charAt(i);
             }
        }

        return result;
    }

    public String removeStars2(String s) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*'){
                if(result.length() > 0){
                    result = result.deleteCharAt(result.length()-1);
                }
            }else{
                result = result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}