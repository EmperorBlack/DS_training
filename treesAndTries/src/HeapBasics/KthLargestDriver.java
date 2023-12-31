package HeapBasics;

import java.util.PriorityQueue;

public class KthLargestDriver {
    public static void main(String[] args) {
        System.out.println(new Solution2().findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}

class Solution2 {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int num :nums
             ) {
            p.offer(num);
        }
        for (int i = 0; i < nums.length - k; i++) {
           p.poll();
        }


    return p.poll();
    }
}

class Solution3 {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> p = new PriorityQueue<>(k);
        for (int num :nums
        ) {
            p.offer(num);
            if(p.size() > k){
                p.poll();
            }
        }
        return p.poll();
    }
}
