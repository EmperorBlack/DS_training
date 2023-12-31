package HeapBasics.MergeKsortedArray;

import java.util.ArrayList;
import java.util.PriorityQueue;

class ArrayTracker{
    int value;
    int arrayIndex;
    int valueIndex;

    public ArrayTracker(int value, int arrayIndex, int valueIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.valueIndex = valueIndex;
    }
}

public class MergeKSortedDriver {

    public static void main(String[] args) {

    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        PriorityQueue<ArrayTracker> pq = new PriorityQueue<>((x,y)->Integer.compare(x.value,y.value));
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < kArrays.size(); i++) {
            pq.offer(new ArrayTracker(kArrays.get(i).get(0),i,0));
        }

        while (!pq.isEmpty()){
            ArrayTracker tracker = pq.poll();
            res.add(tracker.value);
            if(tracker.valueIndex+1 < kArrays.get(tracker.arrayIndex).size()){
                pq.offer(new ArrayTracker(kArrays.get(tracker.arrayIndex).get(tracker.valueIndex+1), tracker.arrayIndex, tracker.valueIndex+1));
            }
        }
        return res;
    }
}
