package stackTrainning;


import java.util.Stack;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }

    Node(){
        super();
    }
}

class MyStack{

    private Node head;

    public void push(int val){
        if(head == null){
            head = new Node(val);
        }else{
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }
    }

    public int peek(){
        if(head == null){
            throw new RuntimeException("underflow");
        }else {
            return head.val;
        }
    }

    public int pop(){
        if(head == null){
            throw new RuntimeException("underflow");
        }else {
            int val = head.val;
            head = head.next;
            return val;
        }
    }

    public void traverseStack(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public Node getHead(){
        return head;
    }

}

public class StackDriverClass {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.traverseStack();

        stack.peek();
        stack.traverseStack();
        stack.pop();
        stack.traverseStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();


    }



}
