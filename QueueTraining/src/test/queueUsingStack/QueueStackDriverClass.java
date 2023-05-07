package test.queueUsingStack;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> queuedStack = new Stack<>();

    public MyQueue() {

    }

    public Object push(int x) {
        stack.push(x);
        return null;
    }

    public int pop() {
        if(queuedStack.isEmpty()){
            reversingQueue();
        }
        return  queuedStack.pop();
    }

    public int peek() {
        if(queuedStack.isEmpty()){
            reversingQueue();
        }
     return queuedStack.peek();
    }

    public boolean empty() {
        return queuedStack.isEmpty() && stack.isEmpty();
    }

    public void reversingQueue(){
        while(!stack.empty()){
            queuedStack.push(stack.pop());
        }
    }
}

public class QueueStackDriverClass {
    public static void main(String[] args) {
//        "push", "push", "peek", "pop", "empty"
        MyQueue q = new MyQueue();
        System.out.println(q.push(1));
        System.out.println(q.push(2));
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
