package stackTrainning;


import java.util.Stack;

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }

    public void pop() {
        System.out.println(minStack.peek() == stack.peek());
        if( stack.peek().equals(minStack.peek())){
            minStack.pop();
            stack.pop();
        }else {
            stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class MinStackDriver {
    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//        minStack.push(512);
//        minStack.push(-1024);
//        minStack.push(-1024);
//        minStack.push(512);
//        minStack.pop();
//        System.out.println(" --- ");
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(" --- ");
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(" --- ");
//        System.out.println(minStack.getMin());
//        System.out.println(-1024 == -1024);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1024);
        stack2.push(1024);
        Integer val1 = stack1.peek();
        Integer val2 = stack2.peek();
        System.out.println(stack1.peek() == stack2.peek());
        System.out.println(val1.equals( val2));
    }
}
