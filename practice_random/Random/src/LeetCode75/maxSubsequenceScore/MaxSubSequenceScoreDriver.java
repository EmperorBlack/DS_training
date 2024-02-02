package LeetCode75.maxSubsequenceScore;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubSequenceScoreDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().maxScore(new int[]{1,3,3,2},new int[]{2,1,3,4},3));
    }
}

class Pair{
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Pair[] pairs = new Pair[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new Pair(nums1[i],nums2[i]);
        }
        Arrays.sort(pairs,(p1,p2)->Integer.compare(p2.b,p1.b));

        long sum =0; long max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            queue.offer(pairs[i].a);
            sum = sum+pairs[i].a;
        }
        max = Math.max(max,sum*pairs[k-1].b);

        for (int i = k; i < pairs.length; i++) {
            sum = sum - queue.poll();
            sum = sum+pairs[i].a;
            queue.offer(pairs[i].a);
            long result = sum*pairs[i].b;
            max = Math.max(max,result);
        }
        return max;

    }
}
