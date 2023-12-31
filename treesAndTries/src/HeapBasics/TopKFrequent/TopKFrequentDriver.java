package HeapBasics.TopKFrequent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentDriver {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }
}



//class Pair{
//    int key;
//    int freq;
//
//    public Pair(int key, int freq) {
//        this.key = key;
//        this.freq = freq;
//    }
//}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int num:nums
             ) {
            map.put(num, map.getOrDefault(num,0)+1);
        }


        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((x,y)->x.getValue()-y.getValue());


        for (Map.Entry<Integer,Integer> entry: map.entrySet()
             ) {pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }


        return res;
    }
}