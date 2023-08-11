package test.trappingrainwater;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWaterDriver {
    public static void main(String[] args) {

        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trapWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }

    public static int trapWater(int[] height) {

        int sum = 0;
        int[] preBig = new int[height.length];
        int[] nxtBig = new int[height.length];



        int max = 0;
        for(int i =0;i<height.length;i++){

            if(height[i] < max){
                preBig[i] = max;
            }else {
                preBig[i] = -1;
            }

            if(height[i] > max)
                max = height[i];
        }

        max =0;

        for(int i = height.length-1;i>=0;i--){

            if(height[i] < max){
                nxtBig[i] = max;
            }else {
                nxtBig[i] = -1;
            }

            if(height[i] > max)
                max = height[i];
        }


        for (int i = 0; i < height.length; i++) {
            int water = Math.min(preBig[i],nxtBig[i])-height[i];
            sum = sum + (water > 0 ? water : 0);
        }

        return sum;
    }

    public static int trap(int[] height) {

        int sum = 0;
        int[] preBig = new int[height.length];
        int[] nxtBig = new int[height.length];

        Stack<Integer> stack= new Stack<>();

        for(int i =0;i<height.length;i++){

            while (!stack.isEmpty() && height[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                preBig[i] = -1;
            }else {
                preBig[i] = stack.peek();
            }
            if(stack.isEmpty() )
                stack.push(height[i]);
        }

        stack.removeAllElements();

        for(int i = height.length-1;i>=0;i--){

            while (!stack.isEmpty() && height[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                nxtBig[i] = -1;
            }else {
                nxtBig[i] = stack.peek();
            }

            if(stack.isEmpty() )
                stack.push(height[i]);
        }



        System.out.println(Arrays.toString(preBig));
        System.out.println(Arrays.toString(nxtBig));

        for (int i = 0; i < height.length; i++) {
            int water = Math.min(preBig[i],nxtBig[i])-height[i];
            sum = sum + (water > 0 ? water : 0);
        }

        return sum;
    }
}
