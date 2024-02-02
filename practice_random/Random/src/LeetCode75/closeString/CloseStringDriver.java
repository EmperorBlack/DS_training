package LeetCode75.closeString;

import java.util.*;

public class CloseStringDriver {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean closeStrings(String word1, String word2) {

        if(word1.length() != word2.length()){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();


        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            map1.put(c1, map1.getOrDefault(c1,0)+1);
            char c2 = word2.charAt(i);
            map2.put(c2, map2.getOrDefault(c2,0)+1);
        }

        if(map1.size() != map2.size()){
            return false;
        }

        List<Integer> count1 = new ArrayList<>(map1.values());
        Collections.sort(count1);
        List<Integer> count2 = new ArrayList<>(map2.values());
        Collections.sort(count2);

        return count1.equals(count2) && map1.keySet().equals(map2.keySet());


    }
}
