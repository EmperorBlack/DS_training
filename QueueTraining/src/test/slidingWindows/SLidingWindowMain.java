package test.slidingWindows;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SLidingWindowMain {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int result[] = new int[(nums.length-k)+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i =0;i< nums.length;i++){

            if(!deque.isEmpty() && deque.getFirst() < (i-k)+1){
                deque.remove();
            }

            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            deque.offer(i);

            if(i>= k-1){
                result[(i-k)+1] = nums[deque.getFirst()];
            }

        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,-1},1)));

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);

//        deque.remove();
        deque.removeLast();
    }
}
