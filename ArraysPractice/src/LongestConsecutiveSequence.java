import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String args[]){
System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutiveSeries(new int[]{0,3,7,2,5,8,4,6,0,1}));

    }
    public static  int longestConsecutiveSeries(int[] nums) {

        Map<Integer, Integer> value = new HashMap<>();
        int max = 0;
        for (int num:nums
             ) {
            if(!value.containsKey(num)){

                int left = value.containsKey(num-1) ? value.get(num-1) : 0;
                int right = value.containsKey(num+1) ? value.get(num+1) : 0;
                int sum = left+right+1;
                value.put(num,left+right+1);
                max = Math.max(max,sum);

                if(value.containsKey(num-1))
                    value.put(num-left,sum);
                if(value.containsKey(num+1))
                    value.put(num+right,sum);
            }

        }

        return max;

    }


    public static  int longestConsecutive(int[] nums) {

        Set<Integer> value = new HashSet<>();
        for(int i : nums){
            value.add(i);
        }
        int max = 1;
        for(int i =0;i<nums.length;i++){
            int sequence = 0;
            int k = nums[i];
            if(value.remove(nums[i])){
                sequence++;
                while(value.remove(k-1)){
                    sequence++;
                    k--;
                }
                k = nums[i];
                while (value.remove(k+1)){
                    sequence++;
                    k++;
                }
                max = Math.max(max,sequence);
            }
        }
        return max;

    }

}
