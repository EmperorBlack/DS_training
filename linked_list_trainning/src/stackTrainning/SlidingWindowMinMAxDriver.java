package stackTrainning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

 class Solution {

    public static int[] maxMinWindow(int[] a, int n) {

        int[] result = new int[n];
        for (int i = 1; i <=n ; i++) {
            result[i-1] = getMaximum(a,i);
        }
        return result;

    }

    public static int getMaximum(int[] a, int n){
        Deque<Integer> deque = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {

            if(!deque.isEmpty() && deque.peek() < (i+1)-n){
                deque.remove();
            }

            while (!deque.isEmpty() && a[i] <= a[deque.getLast()]){
                deque.removeLast();
            }
            deque.offer(i);
            if(i>=n-1){
                int min = a[deque.peek()];
                if(min > max){
                    max = min;
                }
            }


        }
        return max;
    }
}
public class SlidingWindowMinMAxDriver {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.maxMinWindow(new int[]{45,-2,42,5 ,-11},5)));
    }
}
