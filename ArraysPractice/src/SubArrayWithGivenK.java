import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenK {

    public static void main(String args[]){

        System.out.println(getSubArrCount(new int[]{ 1, 2, 2, 3},0));

        System.out.println(getSubArrCount(new int[]{2,3,3,-1,0,7,-2,5},5));

    }

    public static int getSubArrCount(int []nums,int target){
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0;
        for (int num: nums
             ) {
            sum = sum+num;
            if(map.containsKey(sum-target)){
                count=count+map.get(sum-target);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else {
                map.put(sum,1);
            }

        }
        return count;

    }
}
