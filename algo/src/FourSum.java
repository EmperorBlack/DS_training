import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String args[]){
        System.out.println(getFourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
    }

    public static List<List<Integer>> getFourSum(int nums[],int target){

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i<nums.length-3;i++){
            if(i==0 || nums[i-1] != nums[i]){
                for (int j=i+1;j<nums.length-2;j++){
                    if(j==(i+1) || nums[j-1] != nums[j]){
                        getTwoSum(nums,((long)(target-nums[i]))-nums[j],i,j,ans);
                    }
                }
            }

        }
        return ans;

    }

    public static void getTwoSum(int nums[],long target,int i,int j, List<List<Integer>> ans){

        int start = j+1;
        int end = nums.length-1;

        while(start < end){

            if(nums[start]+nums[end] > target){
                end--;
            }else if(nums[start]+nums[end] < target){
                start ++;
            }else{
                ans.add(Arrays.asList(nums[start],nums[end],nums[i],nums[j]));
                start++;
                end--;
                while(start < end && nums[start] == nums[start-1]) {start++;}
                while(start < end && nums[end] == nums[end+1]) {end--;}
            }

        }


    }
}
