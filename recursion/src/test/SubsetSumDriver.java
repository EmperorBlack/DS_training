package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubsetSumDriver {
    public static void main(String[] args) {
//        System.out.println(subsetsSum(new int[]{3,1,2
//        }));
        System.out.println(subsetsSumStriver(new int[]{3,1,2
        }));

    }

    public static List<Integer> subsetsSum(int[] nums) {

     List<Integer> result = new ArrayList<>();

        findSubsets(nums,0,result,0);
        Collections.sort(result);
        return result;

    }
    public static void findSubsets(int[] nums,int start,List<Integer> result, int sum) {

        result.add(sum);
        for (int i = start; i < nums.length; i++) {
            sum = sum + nums[i];
            findSubsets(nums,i+1 ,result,sum);
            sum = sum - nums[i];
        }

    }

    public static List<Integer> subsetsSumStriver(int[] nums) {

        List<Integer> result = new ArrayList<>();

        findSubsetsHelper(nums,0,result,0,nums.length);
        Collections.sort(result);
        return result;

    }

    public static void findSubsetsHelper(int[] nums,int start,List<Integer> result, int sum, int n) {

        if(start == n){
            result.add(sum);
            return;
        }
        findSubsetsHelper(nums,start+1,result,sum+nums[start],n);
        findSubsetsHelper(nums,start+1,result,sum,n);

    }

}
