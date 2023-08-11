import java.util.Arrays;

public class SortColour {
    public static void main(String args[]){

       int[] nums = new int[]{2,0,2,1,1,0};

//        for(int i=1;i<nums.length;i++){
//            int j = i-1;
//            int pivot = nums[i];
//            while(j>=0 && pivot<nums[j]){
//                nums[j+1] = nums[j];
//                j--;
//            }
//            nums[j+1] = pivot;
//        }
        sortColors(nums);

        System.out.print(Arrays.toString(nums));

    }

    public static void sortColors(int[] nums) {
        int redIdx = 0;
        int blueIdx = nums.length-1;
        for (int i = 0; i <= blueIdx; ) {

            if(nums[i] == 2){
                swap(nums,i,blueIdx);
                blueIdx--;
            } else if (nums[i] ==0) {
                swap(nums,i,redIdx);
                redIdx++;
                i++;
            }else {
                i++;
            }

        }
    }

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
