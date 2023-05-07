package test.lru;

import java.util.HashMap;
import java.util.Map;

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
class LRUcache {
    Node rear = new Node(-1, -1);
    Node front = new Node(-1, -1);
    int capacity;
    int size;
    Map<Integer, Node> map = new HashMap<>();

    LRUcache(int capacity) {
        this.capacity = capacity;
        rear.prv = front;
        front.next = rear;
    }

    public void addNode(Node node){
        Node temp = front.next;
        front.next = node;
        node.prv = front;

        node.next = temp;
        temp.prv = node;

    }

    public void removeNode(Node node){
        node.next.prv =node.prv;
        node.prv.next = node .next;
    }

    public void removeTail(){
        Node node = rear.prv;
        map.remove(node.key);
        removeNode(node);
    }

    public Object put(int key, int value){
        Node node = null;
        if(map.containsKey(key)){
             node = map.get(key);
             node.val = value;
             removeNode(node);
             addNode(node);
        }else{
            node = new Node(key,value);
            if(size == capacity){
                removeTail();
                size--;
            }
            addNode(node );
            map.put(key,node);
            size++;
        }
        return null;
    }
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;

    }
}

public class LRUChacheNewDriver {
    public static void main(String[] args) {

        LRUcache cache = new LRUcache(2);

//        soutcache.put(1,1);
//        cache.put(2,2);
//        cache.put(3,3);
//        cache.put(4,4);
//        cache.removeTail();
//        cache.put(2,5);

//        [[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        System.out.println(cache.put(1,1));
        System.out.println(cache.put(2,2));
        System.out.println(cache.get(1));
        System.out.println(cache.put(3,3));
        System.out.println(cache.get(2));
        System.out.println(cache.put(4,4));
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
