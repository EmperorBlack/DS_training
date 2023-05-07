import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String args[]){
        System.out.println(getTriplets(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> getTriplets(int nums[]){
        Map<Integer,Integer> values = new HashMap<>();
        Set<List<Integer>> ans = new HashSet<>();

        for (Integer i: nums
             ) {
            if(values.containsKey(i)){
                values.put(i,values.get(i)+1);
            }else {
                values.put(i,1);
            }
        }

        for(int i =0;i<nums.length-2;i++){
          getTwoSum(i,nums,0-nums[i],values,ans);
        }
        return new ArrayList<>(ans);
    }

    public static void getTwoSum(int i , int nums[], int target, Map<Integer,Integer> values,Set ans){


            values.put(nums[i],values.get(nums[i])-1);

        for(int j =i+1;j<nums.length-1;j++){

            values.put(nums[j],values.get(nums[j])-1);

            if(values.containsKey(target-nums[j]) && values.get(target-nums[j]) > 0 ){
                List l = Arrays.asList(nums[j],target-nums[j],nums[i]);
                Collections.sort(l);
                ans.add(l);
            }
            values.put(nums[j],values.get(nums[j])+1);
        }
        values.put(nums[i],values.get(nums[i])+1);

    }


}
