package test.stackUsingQUeue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue  = new LinkedList<>();


    public MyStack() {

    }

    public void push(int x) {

        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
    return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

public class StackUsingQUeueDriver {
    public static void main(String[] args) {

        Queue<Integer> queue  = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);




    }
}
