package test.subset;

import java.util.*;
import java.util.stream.Stream;

public class RecursiveMain {

    public static void main(String[] args) {
//        System.out.println(subsets(new int[]{1,2,3}));

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        List<Integer> ls2 = new ArrayList<>();
        ls2.add(2);
        set.add(ls1);
        set.add(ls2);

        System.out.println(set);

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

}
