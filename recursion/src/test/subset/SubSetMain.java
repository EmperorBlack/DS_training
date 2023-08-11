package test.subset;

import java.util.ArrayList;
import java.util.List;

public class SubSetMain {
    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1,2,3}));

    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums){
            int size = result.size();
            for(int i =0;i<size;i++){
                ArrayList<Integer> newSub = new ArrayList<>(result.get(i));
                newSub.add(num);
                result.add(newSub);
            }

        }
        return result;

    }
}
