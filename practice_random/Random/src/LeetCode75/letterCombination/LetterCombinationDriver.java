package LeetCode75.letterCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().letterCombinations(""));

    }
}
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            if(map.containsKey(digits.charAt(i))){
                list.add(map.get(digits.charAt(i)));
            }
        }

        List<String> result = new ArrayList<>();
        if(list.isEmpty()){
            return result;
        }
        getCombination(list,0,result,new StringBuilder());
        return result;

    }

    public void getCombination(List<String> list, int index, List<String> result, StringBuilder temp ){

        if(temp.length() == list.size()){
            result.add(new String(temp));
            return;
        }

        for (int i = 0; i < (list.get(index)).length(); i++) {

            temp.append((list.get(index)).charAt(i));
            getCombination(list,index+1,result,temp);
            temp.deleteCharAt(temp.length()-1);
        }


    }
}