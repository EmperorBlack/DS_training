package test.lfu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Node{
    Node next;
    Node prv;
    int val;
    int key;

    int frequency;

    Node( int key,int val)
    {
        this.val = val;
        this.key = key;
        this.frequency = 1;
    }
}
class Cache {
    Node rear = new Node(-1, -1);
    Node front = new Node(-1, -1);

    Cache() {
        rear.prv = front;
        front.next = rear;
    }

    public void addNode(Node node){
        Node temp = rear.prv;
        temp.next = node;
        node.prv = temp;
         node.next = rear;
         rear.prv = node;

    }

    public void removeNode(Node node){
        node.next.prv =node.prv;
        node.prv.next = node.next;
    }

    public int removeTail(){
        Node node = front.next;
        removeNode(node);
        return node.key;
    }

}

class LFUCache{
    Map<Integer,Node> keyMap = new HashMap<>();
    Map<Integer,Cache> frequencyMap = new HashMap<>();
    int size = 0;
    int capacity;
    int leastFrequency = 1;

    LFUCache(int capacity){
        this.capacity = capacity;
    }

    public void addNode(int frequency,Node node){
        Cache c = frequencyMap.getOrDefault(frequency,new Cache());
        node.frequency = frequency;
        c.addNode(node);
        frequencyMap.put(frequency,c);
    }
    public void removeNode(int frequency,Node node){
        Cache c = frequencyMap.getOrDefault(frequency,new Cache());
        c.removeNode(node);
        if(frequency == leastFrequency && c.front.next == c.rear){
            leastFrequency++;
        }
    }

    public void removeTail(int frequency){
        Cache c = frequencyMap.getOrDefault(frequency,new Cache());
        int key = c.removeTail();
        keyMap.remove(key);
    }

    public Object put(int key, int value){
        if(keyMap.containsKey(key)){
            Node n = keyMap.get(key);
            int currFrequency = n.frequency;
            n.val = value;
            keyMap.put(key,n);
            removeNode(currFrequency,n);
            addNode(++currFrequency,n);
        }else {
            if(capacity == size){
                removeTail(leastFrequency);
                size--;
            }
            Node n = new Node(key, value);
            addNode(1,n);
            leastFrequency = 1;
            keyMap.put(key,n);
            size++;
        }
        return null;
    }
    public int get(int key){
        Node n = keyMap.get(key);
        if(n == null){
            return -1;
        }
        removeNode(n.frequency,n);
        addNode(n.frequency+1,n);
        HashSet<Integer> had = new HashSet<>();
        had.iterator().next();
        return n.val;
    }


}



public class LFUDriverClass {
    public static void main(String[] args) {
//[1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4
        LFUCache cache = new LFUCache(2);
        System.out.println(cache.put(1,1));
        System.out.println(cache.put(2,2));
        System.out.println(cache.get(1));
        System.out.println(cache.put(3,3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.put(4,4));
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));



    }
}
