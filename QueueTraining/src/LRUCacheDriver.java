import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    Node rear;
    Node front;
    int capacity;
    int size;
    Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity  = capacity;
    }

    public int get(int key) {

        Node result = map.get(key);
        if(result == null){
            return  -1;
        }

        Node prvNode = result.prv;
        Node nxtNode = result.next;

        if(prvNode==null && nxtNode==null){
            return result.val;
        }

        if (prvNode != null) {
            prvNode.next = nxtNode;
        }else{
            front = front.next;
            front.prv = null;
        }
        if (nxtNode != null) {
            nxtNode.prv = prvNode;
        }else{
            rear = rear.prv;
            rear.next = null;
        }

        result.next =result.prv = null;
        Node temp = rear;
        rear.next = result;
        rear = rear.next;
        rear.prv = temp;


        return result.val;

    }

    public Object put(int key, int value) {

        Node temp = null;
        if(map.containsKey(key)){
            temp = map.get(key);
            temp.val = value;

            Node prvNode = temp.prv;
            Node nxtNode = temp.next;
            if(prvNode==null && nxtNode==null){
                return null;
            }
            if (prvNode != null) {
                prvNode.next = nxtNode;
            }else{
                front = front.next;
                front.prv = null;
            }
            if (nxtNode != null) {
                nxtNode.prv = prvNode;
            }

//            temp.next =temp.prv = null;
            Node tm2 = rear;
            rear.next = temp;
            rear = rear.next;
            rear.prv = tm2;
            rear.next = null;
            return null;
        }else{
            temp = new Node(key,value);
        }


        if(rear == null || front == null){
            rear = temp;
            front = temp;
        }else{
            rear.next = temp;
            temp = rear;
            rear = rear.next;
            rear.prv = temp;
            rear.next = null;
        }
        map.put(key,rear);
        size++;

        if(size==capacity){
            map.remove(front.key);
            size--;
            front = front.next;
            front.prv = null;
            System.out.println("size===>"+size);
        }
    return null;

    }
}


public class LRUCacheDriver {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(10);
        System.out.println(cache.put(10,13));
        System.out.println(cache.put(3,17));
        System.out.println(cache.put(6,11));
        System.out.println(cache.put(10,5));
        System.out.println(cache.put(9,10));
        System.out.println(cache.get(13));
        System.out.println(cache.put(2,19));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.put(5,25));
        System.out.println(cache.get(8));
        System.out.println(cache.put(9,22));
        System.out.println(cache.put(5,5));
        System.out.println(cache.put(1,30));
        System.out.println(cache.get(11));
        System.out.println(cache.put(9,12));
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.get(8));
        System.out.println(cache.get(9));
        System.out.println(cache.put(4,30));
        System.out.println(cache.put(9,3));
        System.out.println(cache.get(9));
        System.out.println(cache.get(10));
        System.out.println(cache.get(10));
        System.out.println(cache.put(6,14));
        System.out.println(cache.put(3,1));
        System.out.println(cache.get(3));
        System.out.println(cache.put(10,11));
        System.out.println(cache.get(8));
        System.out.println(cache.put(2,14));
        System.out.println(cache.get(1));
        System.out.println(cache.get(5));
        System.out.println(cache.get(4));
        System.out.println(cache.put(11,4));
        System.out.println(cache.put(12,24));
        System.out.println(cache.put(5,18));
        System.out.println(cache.get(13));
        System.out.println(cache.put(7,23));
        System.out.println(cache.get(8));
        System.out.println(cache.get(12));
        System.out.println(cache.put(3,27));
        System.out.println(cache.put(2,12));
        System.out.println(cache.get(5));
        System.out.println(cache.put(2,9));
        System.out.println(cache.put(13,4));
        System.out.println(cache.put(8,18));
        System.out.println(cache.put(1,7));
        System.out.println(cache.get(6));
        System.out.println(cache.put(9,29));
        System.out.println(cache.put(8,21));
        System.out.println(cache.get(5));
        System.out.println(cache.put(6,30));
        System.out.println(cache.put(1,12));
        System.out.println(cache.get(10));
        System.out.println(cache.put(4,15));
        System.out.println(cache.put(7,22));
        System.out.println(cache.put(11,26));
        System.out.println(cache.put(8,17));
        System.out.println(cache.put(9,29));
        System.out.println(cache.get(15));
        System.out.println(cache.put(3,4));
        System.out.println(cache.put(11,30));
        System.out.println(cache.get(12));
        System.out.println(cache.put(4,29));
        System.out.println(cache.get(3));
        System.out.println(cache.get(9));
        System.out.println(cache.get(6));
        System.out.println(cache.put(3,4));
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        System.out.println(cache.put(3,29));
        System.out.println(cache.put(10,28));
        System.out.println(cache.put(1,20));
        System.out.println(cache.put(11,13));
        System.out.println(cache.get(3));
        System.out.println(cache.put(3,12));
        System.out.println(cache.put(3,8));
        System.out.println(cache.put(10,9));
        System.out.println(cache.put(3,26));
        System.out.println(cache.get(8));
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.put(13,17));
        System.out.println(cache.put(2,27));
        System.out.println(cache.put(13,17));
        System.out.println(cache.get(12));
        System.out.println(cache.put(9,19));
        System.out.println(cache.put(2,15));
        System.out.println(cache.put(3,16));
        System.out.println(cache.get(1));
        System.out.println(cache.put(12,17));
        System.out.println(cache.put(9,1));


//[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]

    }
}
