package HashSetUsingLinkedListJava;


import java.util.LinkedList;

class MyHashSet {


    LinkedList<Integer>[] bucketList;
    int capacity = 0;
    int initialCapacity = 2;  //prime number

    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.bucketList = new LinkedList[initialCapacity];
    }


    public void add(int key) {
        if(contains(key)){
            return;
        }
        if(size > (initialCapacity*0.75)){
            rehashing();
        }
        int index = hashValue(key,initialCapacity);
        if(bucketList[index] == null){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(key);
            bucketList[index] = list;
        }else {
            LinkedList<Integer> list = bucketList[index];
            list.add(key);
        }
        size++;

    }

    public void remove(int key) {
        LinkedList list  = bucketList[hashValue(key,initialCapacity)];
        if(list!= null ){
           list.removeFirstOccurrence(key);
           size--;
        }

    }



    private int hashValue(int key, int bucketSize) {
        return key % bucketSize;
    }

    public boolean contains(int key) {
        LinkedList list  = bucketList[hashValue(key,initialCapacity)];
        if(list!= null && list.contains(key)){
            return true;
        }else {
            return false;
        }
    }

    public void rehashing(){
        LinkedList<Integer>[] temp = bucketList;
        initialCapacity = initialCapacity*2;
        bucketList = new LinkedList[initialCapacity];
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i] != null)
                for (int num : temp[i]
                     ) {
                    add(num);
                }
        }
    }
}


public class HashSetMain {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);
        hashSet.contains(3);
        hashSet.add(2);
        hashSet.contains(2);
        hashSet.remove(2);
        hashSet.contains(2);

    }
}
