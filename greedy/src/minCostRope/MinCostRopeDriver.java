package minCostRope;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostRopeDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().minCost(new long[]{4 ,3 ,2 ,6},4));
    }


}

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n)
    {
        if(arr.length < 2){
            return 0l;
        }
        Queue<Long> minHeap = new PriorityQueue<>();
        for (long a:arr
             ) {
            minHeap.offer(a);
        }
        long cost = 0l;
        while (minHeap.size() > 1){
            long min1 = minHeap.poll();
            long min2 = minHeap.poll();
            long mergingCost = min1+min2;
            minHeap.offer(mergingCost);
            cost += mergingCost;
        }
        return cost;
    }
}
