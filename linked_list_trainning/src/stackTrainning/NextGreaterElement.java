package stackTrainning;

import java.util.*;
import java.util.stream.Collectors;

public class NextGreaterElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=nums2.length-1 ;i>=0;i--){


                while(!stack.isEmpty() && stack.peek() < nums2[i]){
                    stack.pop();
                }

                if(!stack.isEmpty()){
                    map.put(nums2[i],stack.peek() );
                }

                stack.push(nums2[i]);

        }

        for(int i=0;i<nums1.length;i++){
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }


        return nums1;

    }
}
