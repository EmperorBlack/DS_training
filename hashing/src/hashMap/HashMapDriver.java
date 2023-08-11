package hashMap;

import io.confluent.connect.jdbc.JdbcSinkConnector;

import java.util.LinkedHashSet;
import java.util.LinkedList;

class  Node{
    Node next;
    int key;
    int value;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    Node[] bucketList;
    int initialCapacity = 495;  //prime number

    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {

        this.bucketList = new Node[initialCapacity];
    }


    public void put(int key,int value) {

        int index = hashValue(key,initialCapacity);
        if(bucketList[index] == null){
            Node list = new Node(key,value);
            bucketList[index] = list;
        }else {
            Node list = bucketList[index];
            Node temp = list;
            while(temp!=null){
                if(temp.key == key){
                    temp.value = value;
                    break;
                }
                temp = temp.next;

            }
            if(temp==null){
                Node newNode = new Node(key,value);
                bucketList[index] = newNode;
                newNode.next = list;
            }
        }
        size++;

    }

    public void remove(int key) {
        Node head = new Node(-1,-1);
        Node list  = bucketList[hashValue(key,initialCapacity)];
        head.next = list;
        Node prv = head;
        Node temp = list;
        while(temp!= null){
            if(temp.key == key)
                break;
            prv = temp;
            temp = temp.next;
        }
        if(temp!= null){
            prv.next = temp.next;
        }
        bucketList[hashValue(key,initialCapacity)] = head.next;
    }



    private int hashValue(int key, int bucketSize) {
        return key % bucketSize;
    }

    public int get(int key) {
        Node list  = bucketList[hashValue(key,initialCapacity)];
        Node temp = list;
        while(temp!=null){
            if(temp.key == key){
                return temp.value;
            }
            temp= temp.next;
        }
        return -1;
    }

//    public void rehashing(){
//        LinkedList<Integer>[] temp = bucketList;
//        initialCapacity = initialCapacity*2;
//        bucketList = new LinkedList[initialCapacity];
//        for (int i = 0; i <temp.length ; i++) {
//            if(temp[i] != null)
//                for (int num : temp[i]
//                ) {
//                    add(num);
//                }
//        }
//    }
}
public class HashMapDriver {
    public static void main(String[] args) {
        JdbcSinkConnector jdbc;
        MyHashMap hm = new MyHashMap();
        hm.put(1,1);
        hm.put(2,2);
        hm.get(1);
        hm.get(3);
        hm.put(2,1);
        hm.get(2);
        hm.remove(2);
        hm.get(2);

        LinkedHashSet<Integer> innn = new LinkedHashSet<>();
        innn.add(1);
        innn.add(2);
        innn.add(3);
        innn.add(4);
        int i = innn.iterator().next();
        innn.remove(i);
//        LRU cache = new LRU(2);
    }

}
