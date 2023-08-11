package kdivisiableSubarray;

import java.util.HashSet;
import java.util.Set;

public class KdivisiableSubarrayMain {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(countDistinct(new int[]{1,9,8,7,19},1,6));
    }

    public static int countDistinct(int[] nums, int k, int p) {

        Set<String> result = new HashSet<>();

        for (int i = 0; i < nums.length ; i++) {
            StringBuilder subArray = new StringBuilder("");
            int count = 0;

            for (int j = i; j < nums.length; j++) {
                subArray.append(nums[j]+"-");
                if(nums[j]%p ==0){
                    count++;
                }
                if(count>k){
                    break;
                }
                result.add(subArray.toString());
            }
        }
        return result.size();
    }

}
