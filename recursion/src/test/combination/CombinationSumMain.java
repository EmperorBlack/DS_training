package test.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumMain {
    public static void main(String[] args) {

//        System.out.println("ab".substring(0,3));

//        combinationSum(new int[]{2,3,6,7},7);
        combinationSum(new int[]{10,1,2,7,6,1,5},8);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
//        findCombination(0,target,result,temp,candidates);
//        findCombinations(0,candidates,target,result,temp);
        Arrays.sort(candidates);
        findCombinationsDuplicate(0,candidates,target,result,temp);
        System.out.println(result);
        return result;
    }

    private static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public static void findCombination(int start,int target, List<List<Integer>> result,List<Integer> temp,int[] candidate) {

        if(target < 0){
            return;
        } else if (target ==0) {
            result.add(new ArrayList<>(temp));
        }else{
            for (int i = start; i <candidate.length ; i++) {
                temp.add(candidate[i]);
                findCombination(i,target-candidate[i],result,temp,candidate);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static void findCombinationsDuplicate(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinationsDuplicate(ind+1, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
            while (ind< arr.length-1 && arr[ind] == arr[ind+1]){
                ind++;
            }
        }
        findCombinationsDuplicate(ind + 1, arr, target, ans, ds);
    }
}
