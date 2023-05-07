
class Node{
    Node next;
    Node prv;
    int val;

    int key;

    Node( int key,int val)
    {
        this.val = val;
        this.key = key;
    }
}

class Queue{
    Node rear;
    Node front;

    int size = 0;

    int capacity;

    Queue(int capacity){
        this.capacity = capacity;
    }




}


public class DublyLinkedListQueue {
    public static void main(String[] args) {
//        Queue q = new Queue(4);
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);
//        q.dequeue();
//        q.dequeue();

    }
}
