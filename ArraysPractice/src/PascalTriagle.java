import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriagle {

    public static void main(String args[]){


        System.out.println(getPascalTriangle(5));




    }

    public static List<List<Integer>> getPascalTriangle(int row){
        List<List<Integer>> result = new ArrayList<>();
        if(row == 1){
            result.add(Arrays.asList(1));
            return result;
        }

        if(row == 2){
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1,1));
            return result;
        }


        if(row > 2){
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1,1));

            for(int i=2;i<row;i++){
                List<Integer> neww = new ArrayList<>();
                neww.add(1);
                for(int j=1;j<i;j++){
                    neww.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
                }
                neww.add(1);
                result.add(neww);
            }
        }
        return result;
    }
}
