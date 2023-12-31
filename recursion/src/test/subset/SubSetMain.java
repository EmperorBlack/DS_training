package test.subset;

import java.util.ArrayList;
import java.util.List;

public class SubSetMain {
    public static void main(String[] args) {

        System.out.println(FindAllSubsets(new int[]{1,2,3}));

    }

    public static List<List<Integer>> FindAllSubsets(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        List temp =  new ArrayList<>();
        result.add(temp);

        for(int num : arr){
            int size = result.size();
            for(int i =0;i<size;i++){
                ArrayList<Integer> newSub = new ArrayList<>(result.get(i));
                newSub.add(num);
                result.add(newSub);
            }

        }
        result.remove(temp);
        return result;

    }
}
