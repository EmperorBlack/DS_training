package LeetCode75.smallestInInfiniteSet;

import java.util.PriorityQueue;
import java.util.Queue;

public class SamllestInInfiniteSetDriver {
    public static void main(String[] args) {

        SmallestInfiniteSet s = new SmallestInfiniteSet();
        s.addBack(2);
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());
        s.addBack(1);
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());

    }
}

class SmallestInfiniteSet {

    Queue<Integer> queue ;
    int minNum = 2;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>((x,y)->Integer.compare(x,y));
        queue.offer(1);
    }

    public int popSmallest() {

            int small = queue.poll();
            addBack(minNum++);
            return small;


    }

    public void addBack(int num) {

        if(!queue.contains(num)){
            queue.add(num);
        }
    }
}
