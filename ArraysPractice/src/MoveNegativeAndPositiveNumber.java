import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveNegativeAndPositiveNumber {

    public static void main(String args[]){
    moveNumbers(new int[]{1 ,-1 ,3, 2 ,-7, -5, 11 ,6});
    }

    public static void moveNumbers(int[] nums){

        List<Integer> negative = new ArrayList<>();
        int k =0;
        for(int i=0;i<nums.length;i++){

            if(nums[i] >= 0){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }else{
                negative.add(nums[i] );
            }

        }
        for(int j = k,z=0;j<nums.length;j++,z++){
            nums[j] = negative.get(z);
        }

        System.out.println(Arrays.toString(nums));

    }
}
