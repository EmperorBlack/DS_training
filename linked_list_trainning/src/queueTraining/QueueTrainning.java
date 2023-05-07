package queueTraining;

class MyQueue{
    int capacity;
    int rear;
    int front;
    int data[];

    MyQueue(int capacity){
        this.capacity = capacity;
        rear=0;
        front=0;
        data = new int[capacity];
    }

    public void enqueue(int val){
        if(rear >= capacity){
            throw new RuntimeException("queue is full");
        }
        data[rear] = val;
        rear++;
    }
    public void dequeue(int val){
        if(rear == front){
            throw new RuntimeException("queue is empty");
        }
        for(int i =0;i<rear-1;i++){
            data[i] = data[i+1];
        }
        rear--;
    }
    public int getFront(){
       return data[front];
    }
    public int getRear(){
        return data[rear];
    }
    public boolean isFull(){
        return rear == capacity;
    }
    public boolean isEmpty(){
        return rear == front;
    }

}

public class QueueTrainning {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
//        queue.enqueue(5);
        System.out.println(queue.getFront());
        queue.dequeue(1);
        queue.dequeue(2);
        queue.dequeue(3);
        queue.dequeue(4);
//        queue.dequeue(4);
    }

}
