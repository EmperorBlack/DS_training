import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeate {

    public static void main(String a[]){

        System.out.println(getMaxSubStringLength("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int getMaxSubStringLength(String s){

        int max = 0;
        int start = 0;
        Map<Character,Integer> subString = new HashMap<>();
        for (int i =0; i <s.length();i++
             ) {

            if(!subString.containsKey(s.charAt(i))){
                subString.put(s.charAt(i),i);
            }else {
               start = Math.max(subString.get(s.charAt(i))+1,start);
               subString.put(s.charAt(i),i);
            }
            max = Math.max(max,i-start+1);

        }
        return max;


    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
