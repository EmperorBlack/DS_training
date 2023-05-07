package test.circularDequeue;


class Node{
    Node prv;
    Node nxt;
    int val;

    Node(int val){
        this.val = val;
    }

}



class MyCircularDeque {

    Node front;
    Node rear;
    int size = 0;
    int capacity;

    public MyCircularDeque(int k) {

        this.capacity = k;
    }

    public boolean insertFront(int value) {

        if(size==capacity){
            return false;
        }
       Node node = new Node(value);
       if(front == null && rear == null){
           front = rear = node;
           size++;
           return true;
       }

       front.prv = node;
       node.nxt = front;
       front=front.prv;
       size++;
       return true;
    }

    public boolean insertLast(int value) {
        if(size==capacity){
            return false;
        }
        Node node = new Node(value);
        if(front == null && rear == null){
            front = rear = node;
            size++;
            return true;
        }

        rear.nxt = node;
        node.prv = rear;
        rear = rear.nxt;
        size++;
        return true;
    }

    public boolean deleteFront() {
        Node temp = front;
        if(front!=null){
            front = front.nxt;
            temp.nxt = null;
            if(front!= null){
                front.prv = null;
                size--;
            } else {
                front = rear = null;
            }
            return true;
        }
        return false;

    }

    public boolean deleteLast() {
        Node temp = rear;
        if(rear!=null){
            rear = rear.prv;
            temp.prv = null;
            if(rear!=null){
                rear.nxt = null;
                size--;
            }

            else {
                front = rear = null;
                size=0;
            }
            return true;
        }
        return false;
    }

    public int getFront() {
        if(front!=null){
            return front.val;
        }
        return -1;
    }

    public int getRear() {

        if(rear!=null){
            return rear.val;
        }
        return -1;
    }

    public boolean isEmpty() {

        if(front == null && rear == null){
            return true;
        }
        return false;
    }

    public boolean isFull() {

        if(size==capacity){
            return  true;
        }
        return false;
    }
}
public class DequeueDriverClass {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(8);
//        System.out.println(myCircularDeque.insertLast(1));  // return True
//        System.out.println(myCircularDeque.insertLast(2));  // return True
//        System.out.println(myCircularDeque.insertFront(3)); // return True
//        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
//        System.out.println(myCircularDeque.getRear());      // return 2
//        System.out.println(myCircularDeque.isFull());       // return True
//        System.out.println(myCircularDeque.deleteLast());   // return True
//        System.out.println(myCircularDeque.insertFront(4)); // return True
//        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.insertFront(5));
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.isEmpty());
        System.out.println(myCircularDeque.deleteFront());
        System.out.println(myCircularDeque.insertLast(3));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.insertLast(7));
        System.out.println(myCircularDeque.insertFront(7));
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertLast(4));
        System.out.println(myCircularDeque.isEmpty());

    }
}
