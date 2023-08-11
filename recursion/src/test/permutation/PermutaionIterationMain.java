package test.permutation;

import java.text.SimpleDateFormat;
import java.util.*;

public class PermutaionIterationMain {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{0,1}));
    }

    public static List<List<Integer>> permute(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        result.add(first);

        for(int i =1;i<nums.length;i++){

            List<List<Integer>> temp = new ArrayList<>();

            for (int j = 0; j < result.size(); j++) {

                List<Integer> old = result.get(j);

                for(int k=0;k<=old.size();k++){
                    List<Integer> newList = new ArrayList<>(old);
                    newList.add(k,nums[i]);
                    temp.add(newList);
                }

            }
            result = temp;

        }


        return result;

    }
}
