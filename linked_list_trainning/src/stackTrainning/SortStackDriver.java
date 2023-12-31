package stackTrainning;

import java.util.Stack;

public class SortStackDriver {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(-7);
        stack.push(9);
        stack.push(-2);
        stack.push(5);
        System.out.println(stack);
        Solution3.sortStack(stack);
    }
}

class Solution3 {

    public static void sortStack(Stack<Integer> stack) {
       doSortStack(stack.pop(),stack);
        System.out.println(stack);
    }

    public static void doSortStack(Integer num,Stack<Integer> stack){
        if(!stack.empty()){
            doSortStack(stack.pop(),stack);
            setNumber(num,stack);
        }else{
            stack.push(num);
        }
    }

    public static void setNumber(Integer num,Stack<Integer> stack){
        if(!stack.isEmpty() && stack.peek() <= num){
            Integer temp = stack.pop();
            setNumber(num,stack);
            stack.push(temp);
        }else{
            stack.push(num);
        }
    }

}
