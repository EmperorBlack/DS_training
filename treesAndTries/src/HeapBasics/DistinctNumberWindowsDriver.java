package HeapBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberWindowsDriver {

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.dNums(new ArrayList<>(Arrays.asList(1, 1, 2, 2)),1));
    }
}

 class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            if(map.containsKey(A.get(i))){
                map.put(A.get(i),map.get(A.get(i))+1);
            }else {
                map.put(A.get(i),1);
            }

            if(i-B >=0 && map.containsKey(A.get(i-B))){
                if(map.get(A.get(i-B)) > 1){
                    map.put(A.get(i-B),map.get(A.get(i-B))-1);
                }else {
                    map.remove(A.get(i-B));
                }
            }

            if(i>=B-1){
                result.add(map.size());
            }
        }

        return result;

    }
}
