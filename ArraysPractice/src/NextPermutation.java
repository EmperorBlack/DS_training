import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String args[]){
        int array[] = new int[]{2,3,1};
        findNextPermutation(array);
        System.out.println(Arrays.toString(array));
    }
    public static void findNextPermutation(int[] nums){
        if(nums.length > 1){
            int k = nums.length-2;
            for(int i= nums.length-1;i>0;i--){
                if(nums[i] <nums[i-1] || nums[i] ==nums[i-1]){
                    k--;
                }else{
                    break;
                }
            }
//        if k = -1 return reverse of array
            if(k==-1){
                reverseArray(nums,0,nums.length-1);
            }else {
                //        sort from k+1 to array.length -1 or reverse them

//                for (int j = nums.length-1; j > k; j--) {
//                    if (nums[j] > nums[k]) {
                        int temp = nums[k];
                        nums[k] = nums[k+1];
                        nums[k+1] = temp;
//                        break;
//                    }

//                }
                reverseArray(nums, k + 1, nums.length - 1);
            }


        }
    }

    public static void reverseArray(int array[],int from, int to){
        int reverse = to;
        for(int i=from;i<reverse;i++){
            int temp = array[i];
            array[i] = array[reverse];
            array[reverse] = temp;
            reverse--;
        }
    }
}
