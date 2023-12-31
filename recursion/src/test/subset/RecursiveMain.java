package test.subset;

import java.util.*;
import java.util.stream.Stream;

public class RecursiveMain {

    public static void main(String[] args) {
//        System.out.println(subsets(new int[]{1,2,3}));

        System.out.println(subsets2(new int[]{1,2,3}));


    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
//        nums = Arrays.stream(nums).
        return result;

    }
    public static void findSubsets(int[] nums,int start,List<List<Integer>> result, List<Integer> curr) {

        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            findSubsets(nums,i+1 ,result,curr);
            curr.remove(curr.size()-1);
        }

    }

    public static List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        findSubsets2(nums,0,result,curr);
        return result;

    }
    public static void findSubsets2(int[] nums,int ind,List<List<Integer>> result, List<Integer> curr) {

        if(ind == nums.length){
            result.add(curr);
            return;
        }

        List<Integer> choose = new ArrayList<>(curr);
        choose.add(nums[ind]);
        List<Integer> notChoose = new ArrayList<>(curr);
        findSubsets2(nums,ind+1,result,choose);
        findSubsets2(nums,ind+1,result,notChoose);

    }



}
