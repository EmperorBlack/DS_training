package LeetCode75.maxVowel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowelDriver {
    public static void main(String[] args) {

        System.out.println(new Solution().maxVowels("qempburycnhrvvccr",13));

    }
}

class Solution {
    public int maxVowels(String s, int k) {

        Set<Character> set = new HashSet<>(Arrays.asList('a','i','e','o','u'));
        int max = 0;
        int count =0;
        for (int i = 0; i < s.length(); i++) {

            if(set.contains(s.charAt(i))){
                count++;
                if (count > max){
                    max = count;
                }
            }
            if(i >= (k-1) && set.contains(s.charAt(i-(k-1)))){
                count--;
            }

        }

        return max;
    }
}
