package HeapBasics.MedianFinder;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x,y)->Integer.compare(y,x));
    }

    public void addNum(int num) {

        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
        }else {
            if(maxHeap.peek() >= num){
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }
        }

        if(maxHeap.size()-minHeap.size() >1){
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 0) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

       if(maxHeap.size() > minHeap.size()){
           return maxHeap.peek();
       }else{
           return (minHeap.peek()+maxHeap.peek())/2.0d;
       }
    }
}


public class MedianFinderDriver {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
  }
}
