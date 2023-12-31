package HeapBasics.MergeKSortedAprroach2;


import java.util.ArrayList;
import java.util.PriorityQueue;

class ArrayTracker{
    int value;
    int arrayIndex;

    public ArrayTracker(int value, int arrayIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
    }
}
public class MergeKsortedDriver {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        PriorityQueue<ArrayTracker> pq = new PriorityQueue<>((x, y)->Integer.compare(x.value,y.value));
        ArrayList<Integer> res = new ArrayList<>();
        int[] indexTracker = new int[kArrays.size()];

        for (int i = 0; i < kArrays.size(); i++) {
            pq.offer(new ArrayTracker(kArrays.get(i).get(0),i));
            indexTracker[i] = 0;
        }

        while (!pq.isEmpty()){
            ArrayTracker tracker = pq.poll();
            res.add(tracker.value);
            int index = indexTracker[tracker.arrayIndex]+1;
            if( index < kArrays.get(tracker.arrayIndex).size()){
                pq.offer(new ArrayTracker(kArrays.get(tracker.arrayIndex).get(index), tracker.arrayIndex));
                indexTracker[tracker.arrayIndex]++;
            }
        }
        return res;
    }
}
