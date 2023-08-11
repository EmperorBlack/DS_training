package stackTrainning;

import java.util.Arrays;
import java.util.Stack;

class Solutions {


    public static int[] maxMinWindow(int[] a, int n) {

       int[] prvSmall = new int[n];
       int[] nxtSmall = new int[n];
       int[] result = new int[n];

       Stack<Integer> stack = new Stack<>();
       stack.push(-1);
        for (int i = 0; i < a.length; i++) {
            while(stack.peek()>=0 && a[stack.peek()] >= a[i]){
                stack.pop();
            }
            prvSmall[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(n);
        for (int i = n-1; i >= 0; i--) {
            while(stack.peek()<n && a[stack.peek()] >= a[i]){
                stack.pop();
            }
            nxtSmall[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            int smallFor = nxtSmall[i]-prvSmall[i]-2;
            result[smallFor] = result[smallFor] > a[i] ? result[smallFor] :a[i];
        }

        for (int i = result.length-2; i >=0 ; i--) {

            if(result[i] < result[i+1]){
                result[i] = result[i+1];
            }
        }

//       fo
return result;
    }
}
public class SlidlingWInMinMaxRiddleDriver {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solutions.maxMinWindow(new int[]{45,-2,42,5,-11 },5)));
    }
}
