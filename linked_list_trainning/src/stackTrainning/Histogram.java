package stackTrainning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Histogram {

    public static void main(String[] args) {

        System.out.println(findHistogram(new int[]{2,1,5,6,2,3}));
    }

    public static int findHistogram(int nums[]){

        Stack<Integer> nextSmallStack = new Stack<>();
        Stack<Integer> prvSmallStack = new Stack<>();
        int[] nextSmallIndex = new int[nums.length];
        int[] prvSmallIndex = new int[nums.length];
//        finding next small element

        int index = nums.length;
        for(int i =0;i<nums.length;i++){

            index = (nums.length-1)-i;
            while(!nextSmallStack.isEmpty() && nums[nextSmallStack.peek()] > nums[index]){
                nextSmallStack.pop();
            }

            while(!prvSmallStack.isEmpty() && nums[prvSmallStack.peek()] > nums[i]){
                prvSmallStack.pop();
            }

            if(prvSmallStack.isEmpty()){
                prvSmallIndex[i] = -1;
            }else{
                prvSmallIndex[i] = prvSmallStack.peek();
            }
            prvSmallStack.push(i);

            if(nextSmallStack.isEmpty()){
                nextSmallIndex[index] = nums.length;
            }else{
                nextSmallIndex[index] = nextSmallStack.peek();
            }
            nextSmallStack.push(index);



        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            int area = ((nextSmallIndex[i]-prvSmallIndex[i])-1)*nums[i];
            if(area>max){
                max = area;
            }
        }
        System.out.println("finding next small element"+ Arrays.toString(nextSmallIndex));
        System.out.println("finding prv small element"+ Arrays.toString(prvSmallIndex));
        return max;
    }
}
