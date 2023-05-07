import java.util.Arrays;

public class SortColour {
    public static void main(String args[]){

       int[] nums = new int[]{2,0,2,1,1,0};

        for(int i=1;i<nums.length;i++){
            int j = i-1;
            int pivot = nums[i];
            while(j>=0 && pivot<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = pivot;
        }

        System.out.print(Arrays.toString(nums));

    }
}
