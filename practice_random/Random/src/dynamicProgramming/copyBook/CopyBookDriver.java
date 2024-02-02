package dynamicProgramming.copyBook;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class CopyBookDriver {


    public static void main(String[] args) {

        TreeMap<Integer,Integer> tree = new TreeMap<>((e1,e2)-> e1);


        Queue<Pair> queue = new PriorityQueue<>((p1,p2)-> p2.value-p1.value);
        Pair p = new Pair(2);
        Pair p1 = new Pair(3);


        queue.offer(p1);
        queue.offer(p);

//        p1.value = 1;

        System.out.println(queue.poll().value);

    }

}

class Pair{
    int value;

    public Pair(int value) {
        this.value = value;
    }
}

class Solution{


    public void getMaxCopy(int[] arr){




    }
}
