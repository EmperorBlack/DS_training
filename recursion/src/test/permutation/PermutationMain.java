package test.permutation;

import java.util.*;

public class PermutationMain {

    public static void main(String[] args) {

        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<Integer> trace = new HashSet<>();
        permute(nums,result,temp,trace);

        return result;

    }

    public static void permute(int[] nums, List<List<Integer>> result, List<Integer> temp, Set<Integer> tracing) {

        if(tracing.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(!tracing.contains(i)){
                tracing.add(i);
                temp.add(nums[i]);
                permute(nums,result,temp,tracing);
                tracing.remove(i);
                temp.remove(temp.size()-1);

            }
        }


    }

    public static void permute2(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] freq) {

        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(!freq[i]){
                freq[i] = true;
                temp.add(nums[i]);
                permute2(nums,result,temp,freq);
                freq[i] = false;
                temp.remove(temp.size()-1);
            }
        }


    }

    public static void recurPermute(int[] nums, List<List<Integer>> result,int index) {

        if(index == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i :nums
                 ) {
                list.add(i);
            }
            result.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums,index,i);
            recurPermute(nums,result,index++);
            swap(nums,index,i);
        }


    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }

}
