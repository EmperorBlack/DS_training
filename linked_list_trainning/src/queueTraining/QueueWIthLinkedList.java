package queueTraining;
class Node{
    Node next;
    int val;

    Node(int val){
        this.val = val;
    }
}

class Queue{
    Node rear;
    Node front;

    public void enqueue(int val){

        Node node = new Node(val);
        if(rear == null){
            rear = front = node;
            return;
        }
        rear.next = node;
        rear = rear.next;

    }
    public void dequeue(){

        if(front == null){
            throw  new RuntimeException("underflow");
        }
        Node  temp = front;
        front = front.next;
        temp.next = null;

        if(front == null){
            rear = null;
        }

    }


}


public class QueueWIthLinkedList {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
    }
}
