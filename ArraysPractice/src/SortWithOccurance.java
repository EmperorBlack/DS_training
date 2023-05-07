import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortWithOccurance {

    public static void main(String args[]){

//        Arrays.asList(1,2).stream().filter(o-> !test(0))

        Integer a[] = {1,3,2,3,2,2};
        Map<Integer,Integer> value = new HashMap<>();
        for (int a1:a
             ) {
            if(value.containsKey(a1)){
                value.put(a1,value.get(a1)+1);
            }else {
                value.put(a1,1);
            }
        }
        System.out.println(value);
        Arrays.sort(a, (o1, o2) -> {
            if(value.get(o1) >value.get(o2)){
                return -1;
            }else if(value.get(o1) <value.get(o2)){
                return 1;
            }else{
                if(o1 >o2){
                    return -1;
                }else if(o1 < o2){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        System.out.println(Arrays.toString(a));
    }
}
