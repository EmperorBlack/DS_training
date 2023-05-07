import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String args[]){
        int []a = new int[]{3,2,3};
        System.out.println(Arrays.toString(getTwoSum(a,6)));
    }
    public static int[] getTwoSum(int array[],int target){
        Map<Integer,Integer> data = new HashMap<>();
       for(int i=0;i<array.length;i++){

           if(data.containsKey(target-array[i])){
               return new int[]{i,data.get(target-array[i])};
           }
           data.put(array[i],i);

       }
        return null;
    }










    public static void findTwoSum(){
        int array[] = new int[]{2,7,11,15};
        int target = 9;
        for(int i=0;i< array.length;i++){
            for(int j = i+1;j< array.length;j++){
                if(array[i]+ array[j] ==target){
                    System.out.print(i+ " "+j);
                }
            }
        }

        int result[] = new int[2];
        int count =0;

        int temp[] = Arrays.copyOfRange(array,0,array.length);
        Arrays.sort(temp);
        int lo=0, hi=temp.length-1;
        for(int i=0;i<array.length;i++){
            if(count >=2){
                break;
            }
            if(array[i] == temp[lo]){
                result[count] = i;
                count++;
                continue;
            }
            if(array[i] == temp[hi]){
                result[count] = i;
                count++;
                continue;
            }
        }
        System.out.print(Arrays.toString(result));
    }
}
