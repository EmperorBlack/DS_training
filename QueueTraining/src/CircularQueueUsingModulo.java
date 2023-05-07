class MyCircularQueue {

    int queue[];
    int size =0;
    int capacity;
    int front =0 ;int  rear = -1;

    public MyCircularQueue(int k) {

        queue = new int[k];
        capacity = k;

    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue[(++rear)%capacity] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        queue[front++ % capacity] = 0;
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[front%capacity];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return queue[rear%capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {

        return size == capacity;
    }
}


public class CircularQueueUsingModulo {
    public static void main(String[] args) {
       MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
    }
}
