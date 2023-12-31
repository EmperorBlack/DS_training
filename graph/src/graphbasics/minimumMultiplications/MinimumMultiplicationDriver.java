package graphbasics.minimumMultiplications;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumMultiplicationDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().minimumMultiplications(new int[]{2, 5, 7},3,30));
    }
}

class Pair{
    int node;
    int steps;

    public Pair(int node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        int[] steps = new int [100000];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(start,0));
        steps[start] = 0;


        while (!queue.isEmpty()){

            Pair p = queue.poll();
            if(p.node == end){
                return p.steps;
            }
            for (int i = 0; i < arr.length; i++) {

                int newValue = p.node*arr[i];
                if(newValue >= 100000){
                    newValue = newValue % 100000;
                }

                if(steps[newValue] > p.steps+1){
                    queue.offer(new Pair(newValue,p.steps+1));
                    steps[newValue] = p.steps+1;
                }


            }
        }

        return -1;

    }
}
