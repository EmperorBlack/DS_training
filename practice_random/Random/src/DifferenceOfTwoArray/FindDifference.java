package DifferenceOfTwoArray;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDifference {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (Integer num: set1
             ) {
            if(!set2.contains(num)){
                list1.add(num);
            }
        }

        for (Integer num: set2
        ) {
            if(!set1.contains(num)){
                list2.add(num);
            }
        }

        result.add(list1);
        result.add(list2);

        return result;
    }

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();
//        Set<Integer> set = new HashSet<>();
        for(int a : arr){
           map.put(a, map.getOrDefault(a,0)+1);
        }

        Set<Integer> set = new HashSet<>(map.values());
//        for (Map.Entry<Integer,Integer> m: map.entrySet()
//             ) {
//            set.add(m.getValue());
//        }

        return map.size() == set.size();


    }
}