package test.lru;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

class LRU{
    int capacity;
    int size = 0;
    HashMap<Integer,Integer> keyValue = new HashMap<>();
    LinkedHashSet<Integer> cacheList = new LinkedHashSet<>();

    LRU(int capacity){
        this.capacity = capacity;
    }

    public Object put(int key,int value){
        if(!keyValue.containsKey(key)){

            if(size == capacity){
                Integer removedKey = cacheList.iterator().next();
                cacheList.remove(removedKey);
                keyValue.remove(removedKey);
                size--;
            }
            keyValue.put(key,value);
            cacheList.add(key);
            size++;
        }else {
            cacheList.remove(key);
            cacheList.add(key);
            keyValue.put(key,value);
        }
        return null;
    }
    public int get(int key){
       if(!keyValue.containsKey(key)){
           return -1;
       }
       cacheList.remove(key);
       cacheList.add(key);
       return keyValue.get(key);

    }

}



public class LRUCache {

    public static void main(String[] args) {

        LinkedHashSet<Integer> innn = new LinkedHashSet<>();
        innn.add(1);
        innn.add(2);
        innn.add(3);
        innn.add(4);
         int i = innn.iterator().next();
//        LRU cache = new LRU(2);
//        System.out.println(cache.put(1,1));
//        System.out.println(cache.put(2,2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.put(3,3));
//        System.out.println(cache.get(2));
//        System.out.println(cache.put(4,4));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
    }
}
