import java.util.LinkedList;
import java.util.Queue;

public class RemoveDuplicatedFromSorted {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.remove();

    }

    public int removeDuplicates(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                nums[i-1] = -1;
            }
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=-1){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {

        int index = 1;
        int ele = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != ele){
                nums[index] = nums[i];
                ele = nums[i];
                index++;
            }
        }
        return index;
    }
}
