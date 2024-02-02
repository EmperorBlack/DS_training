package LeetCode75.stringDecode;

import java.util.Stack;

public class StringDecodeDriver {

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString2("2[2[a]]"));
    }
}

class Solution {
    public String decodeString(String s) {


        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

           if(c!=']'){
               stack.push(c);
           }else{
               String temp = "";
               while(stack.peek() != '['){
                   temp = stack.pop()+temp;
               }
               stack.pop();
               String num = "";
               while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                   num = stack.pop()+num;
               }

               int times = num.isEmpty() ? 1 : Integer.parseInt(num);
               for (int j = 0; j < times; j++) {
                   for (int k = 0; k < temp.length(); k++) {
                       stack.push(temp.charAt(k));
                   }
               }

           }


        }
        while (!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
    public String decodeString2(String s) {



        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        StringBuilder tempStr = new StringBuilder();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }else if (c == '['){
                numStack.push(num);
                num = 0;
                stack.push(tempStr);
                tempStr = new StringBuilder();

            } else if (c == ']') {

                StringBuilder temp=tempStr;
                tempStr=stack.pop();
                int count=numStack.pop();
                while(count-->0){
                    tempStr.append(temp);
                }

            }






            else{
                tempStr.append(c);
            }


        }

        return tempStr.toString();
    }
}
