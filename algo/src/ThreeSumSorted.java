import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSorted {

    public static void main(String args[]){
        System.out.println(getTriplets(new int[]{-2,0,0,2,2}));
    }

    public static List<List<Integer>> getTriplets(int nums[]){

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i<nums.length-2;i++){

            if(i==0 || nums[i-1] != nums[i]){
                getTwoSum(nums,0-nums[i],i,ans);
            }

        }
        return ans;

    }

    public static void getTwoSum(int nums[],int target,int i, List<List<Integer>> ans){

        int start = i+1;
        int end = nums.length-1;

        while(start < end){

            if(nums[start]+nums[end] > target){
                end--;
            }else if(nums[start]+nums[end] < target){
                start ++;
            }else{
                ans.add(Arrays.asList(nums[start],nums[end],nums[i]));
                start++;
                end--;
                while(start < end && nums[start] == nums[start-1]) {start++;}
                while(start < end && nums[end] == nums[end+1]) {end--;}
            }

        }


    }
}
