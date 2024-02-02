package LeetCode75.RecentCounter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Stream;

public class RecentCounterDriver {
    public static void main(String[] args) {

        TreeMap<Integer,Integer> tm = new TreeMap<>();
//        tm.tailMap();

        


    }
}

class RecentCounter {

    Queue<Integer> queue ;

    public RecentCounter() {
            queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        int lastRange = t -3000;
        queue.offer(t);
        while(queue.peek()< lastRange){
            queue.poll();
        }
        return queue.size();
    }
}
