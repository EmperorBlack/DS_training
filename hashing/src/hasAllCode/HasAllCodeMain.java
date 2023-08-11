package hasAllCode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length()-(k-1); i++) {
           set.add(s.substring(i,i+k));
        }

        if(set.size() == Math.pow(2,k)){
            return true;
        }else {
            return false;
        }
    }
}
public class HasAllCodeMain {
    public static void main(String[] args) {
        System.out.println(Solution.hasAllCodes("00110",2));
    }
}
