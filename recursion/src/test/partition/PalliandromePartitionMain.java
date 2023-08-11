package test.partition;

import java.util.ArrayList;
import java.util.List;

public class PalliandromePartitionMain {
    public static void main(String[] args) {

        System.out.println(findPartitions("aabb"));

    }

    public static List<List<String>> findPartitions(String str){

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        checkPartitions(str,result,temp,0);
        return result;

    }
    public static void checkPartitions(String str,List<List<String>> result,List<String> temp ,int start){
        if(start == str.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if(isPalliandrom(str.substring(start,i+1))){
                temp.add(str.substring(start,i+1));
                checkPartitions(str,result,temp,i+1);
                temp.remove(temp.size()-1);
            }

        }
    }

    public static boolean isPalliandrom(String str){
        StringBuilder sb1 = new StringBuilder(str);
        return str.equals(sb1.reverse().toString());

    }
}
