package LeetCode75.combinationSum3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumDriver {
    public static void main(String[] args) {

    }
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        findCombinationSum(k,n,1,result,new ArrayList<>());
        return result;
    }

    public void findCombinationSum(int k, int target, int num, List<List<Integer>> result, List<Integer> temp){
        if(target < 0){
            return;
        }
        if(temp.size() == k){
            if(target == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(num > 9){
            return;
        }
        findCombinationSum(k, target, num+1, result, temp);
        temp.add(num);
        findCombinationSum(k,target-num,num+1,result,temp);
        temp.remove(temp.size()-1);


    }
}
