package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDupMain {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums,0,result,curr);
        return result;

    }
    public static void findSubsets(int[] nums,int start,List<List<Integer>> result, List<Integer> curr) {

        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {

            if(i!=start && nums[i] == nums[i-1])
                continue;
            curr.add(nums[i]);
            findSubsets(nums,i+1 ,result,curr);
            curr.remove(curr.size()-1);
        }

    }
}
